package project.logic;

import project.classes.Task;
import project.classes.Utility;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * This ToDo Class contains all the functionalities which are required to create a task.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class ToDo {

    private ArrayList <Task> toDoList;
    private String fileName;

    public ToDo(String fileName) throws IOException {
        File file = new File (fileName);
        this.fileName = fileName;

        if (file.exists()){
            toDoList = Utility.readFile(fileName);
        } else {
            toDoList = new ArrayList<>();
        }
    }


    public void printAllTasksByProject (){

        if (toDoList.size() == 0){
            System.out.println("Task List is empty....\n");
        }
        ArrayList <Task> tempraryList = new ArrayList<>(toDoList);

        Collections.sort(tempraryList, Utility.NameComparator);

        for (Task task:tempraryList) {
            System.out.println("\n" + task.toString());
        }
    }

    public void printAllTasksByDate() {
        if (toDoList.size() == 0){
            System.out.println("Task List is empty....\n");
        }

        ArrayList <Task> tempraryList = new ArrayList<>(toDoList);

        Collections.sort(tempraryList, Utility.DateComparator);

        for (Task task:tempraryList) {
            System.out.println("\n" + task.toString());
        }
    }

    public void addTaskIntoTheList (Task task){
        toDoList.add(task);
    }

    public Task createTask (){
        Scanner reader = new Scanner (System.in);
        System.out.println("Task detail:");

        System.out.println("Enter heading of your task:");
        String heading = reader.nextLine();

        System.out.println("Enter date and time of your task:");

        Date dateTime = Utility.getDateAndTime();

        boolean completed = false;

        displayProjectsName();

        String project = chooseProject();

        int id = generateTaskId();

        Task task = new Task (id, heading, dateTime, completed, project);

        return task;
    }

    private int generateTaskId (){

        int id;
        if (toDoList.size()== 0){
            id = 1;
        }else {
            Task task = toDoList.get(toDoList.size()-1);
            id = task.getId() + 1;
        }
        return id;
    }
    private void displayProjectsName (){

        System.out.println("Select Project type from the list: 1 - " + (Task.projects.length));
        for (int i = 0; i < Task.projects.length; i++) {
            System.out.println((i + 1) + " - " + Task.projects [i]);
        }
    }

    private String chooseProject (){

        int result;

        while (true) {

            System.out.println("Choose the number : ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            result = Integer.parseInt(input);

            if (result > 0 && result <= Task.projects.length){
                break;
            }
            System.out.println(result + " is an invalid input");
        }
            return Task.projects[result-1];
    }

    public boolean removeTask (int taskId){

        boolean answer = false;
        for (int i = 0; i < toDoList.size(); i++) {
            if (toDoList.get(i).getId() == taskId) {
                if (toDoList.remove(i) != null) {
                    answer = true;
                }
                break;
            }
        }
        return answer;
    }

    public boolean markTaskAsDone (int taskId){


        boolean answer = false;
        for (int i = 0; i < toDoList.size() ; i++) {
            if (toDoList.get(i).getId() == taskId){
                toDoList.get(i).setCompleted(true);
                answer = true;
                break;
            }
        }
        return answer;
    }

    public boolean updateTask (int taskId){

        boolean answer = false;
        for (int i = 0; i < toDoList.size() ; i++) {
            if (toDoList.get(i).getId() == taskId){
                Task task = toDoList.get(i);
                task = updateExistingTask(task);
                toDoList.set(i,task);
                break;
            }
        }
        return answer;
    }

    private Task updateExistingTask (Task task){

        Scanner scanner = new Scanner (System.in);
        System.out.println("Update Task detail:");

        System.out.println("Enter heading to update task:");
        String heading = scanner.nextLine();
        task.setHeading(heading);

        System.out.println("Enter date and time to update task:");
        Date dateTime = Utility.getDateAndTime();
        task.setDate(dateTime);

        boolean completed = false;
        task.setCompleted(completed);

        displayProjectsName();
        String project = chooseProject();
        task.setProject(project);

        return task;
    }
    public void saveFile (){
        Utility.saveFile(fileName,toDoList);
    }
    public int getTaskCount (){
        return toDoList.size();
    }
    public int getCountOfCompletedTasks () {

        int count = 0;

        for (int i = 0; i < toDoList.size(); i++) {

            Task task = toDoList.get(i);
            if (task.isCompleted()) {
                count++;
            }
        }
        return count;
    }
    public int getCountOfRemainingTasks (){
       return getTaskCount() - getCountOfCompletedTasks();
    }
}
