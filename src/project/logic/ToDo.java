package project.logic;

import project.classes.Task;
import project.classes.Utility;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

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

    /**
     * Constructor takes source fileName as a parameter.
     * If file exists it loads the records and insert it into ToDoList.
     * If file does not exist it creates a new ToDoList.
     *
     * @param fileName
     * @throws IOException
     */
    public ToDo(String fileName) throws IOException {
        File file = new File (fileName);
        this.fileName = fileName;

        if (file.exists()){
            toDoList = Utility.readFile(fileName);
        } else {
            toDoList = new ArrayList<>();
        }
    }


    /**
     * Prints tasks list by projects. When list of tasks is empty user receives information about that.
     */
    public void printAllTasksByProject (){


        if (toDoList.size() == 0){
            System.out.println("Task List is empty....\n");
            return;
        }
        ArrayList <Task> temporaryList = new ArrayList<>(toDoList);

        Collections.sort(temporaryList, Utility.NameComparator);

        temporaryList.stream().forEach(System.out::println);
    }

    /**
     * Prints tasks list by date. When list of tasks is empty user receives information about that.
     */
    public void printAllTasksByDate() {
        if (toDoList.size() == 0){
            System.out.println("Task List is empty....\n");
            return;
        }

        ArrayList <Task> temporaryList = new ArrayList<>(toDoList);

        Collections.sort(temporaryList, Utility.DateComparator);

        temporaryList.stream().forEach(System.out::println);
    }

    /**
     * This method is helping to add task into the list
     * @param task
     */
    public void addTaskIntoTheList (Task task){
        if (toDoList.add(task)){
            System.out.println("Task added successfully....\n");
            System.out.println(task.toString());
        }
    }

    /**
     * This method takes input from the user and create a task.
     * User receives complete task as an output.
     * @return Task
     */
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

    /**
     * This method get the last task element of the list, reads the task id and generate a new id for next task.
     * If the list is empty the task id starts from #1
     * @return int
     */
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

    /**
     * Displays the available projects. User see the list of projects here.
     */
    private void displayProjectsName (){

        System.out.println("Select Project type from the list: 1 - " + (Task.projects.length));

        for (int i = 0; i < Task.projects.length; i++) {
            System.out.println((i + 1) + " - " + Task.projects [i]);
        }
    }

    /**
     * This method allows user to choose the available projects from the list.
     * User can choose available project from Array by adding correct #.
     * If input is incorrect it shows the error message and displays the list again.
     * @return String
     */
    private String chooseProject (){

        int result;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Choose the number : ");
            String input = scanner.nextLine();

            result = Integer.parseInt(input);

            if (result > 0 && result <= Task.projects.length){
                break;
            }
            System.out.println(result + " is an invalid input");
        }
            return Task.projects[result-1];
    }

    /**
     * Removes task from the list. User is able to remove task from list by using id # of task.
     * If task is removed successfully the method returns true otherwise false.
     * @param taskId
     * @return boolean
     */
    public boolean removeTask (int taskId){

        boolean answer = false;

        answer = toDoList.removeIf(task -> (task.getId() == taskId) );

        return answer;
    }

    /**
     * Updates the task as done. User is able to mark task as done in available list
     * If task is marked successfully the method returns true otherwise false.
     * @param taskId
     * @return boolean
     */
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

    /**
     * Updates the entire task.
     * @param taskId
     * @return boolean
     */
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

    /**
     * This method takes the input from the user to update the existing task
     * @param task
     * @return Task
     */
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

    /**
     * This method helps user to save a file
     */
    public void saveFile (){
        Utility.saveFile(fileName,toDoList);
    }

    /**
     * This method returns total count of tasks
     * @return
     */
    public int getTaskCount (){
        return toDoList.size();
    }

    /**
     * This method returns the count of completed tasks
     * @return int
     */
    public long getCountOfCompletedTasks () {

        long count = 0;

        Stream s = toDoList.stream().filter(task -> task.isCompleted());
        count = s.count();

        return count;
    }

    /**
     * This method returns the count of remaining tasks
     * @return int
     */
    public long getCountOfRemainingTasks (){
       return getTaskCount() - getCountOfCompletedTasks();
    }
}
