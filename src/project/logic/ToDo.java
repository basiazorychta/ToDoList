package project.logic;


import project.classes.Task;
import project.classes.Utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ToDo {

    private ArrayList <Task> toDoList;

    public ToDo() {
        toDoList = new ArrayList<>();
    }
    public void printAllTasks (){
        for (Task task:toDoList) {
            System.out.println(task.toString());
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
        Date dateTime = Utility.createDateTime();

        boolean completed = false;

        System.out.println("Select Project type from the list: 1 - " + (Task.projects.length));
        displayProjectsName();
        String project = chooseProject();

        int id;
        if (toDoList.size()== 0){
            id = 1;
        }else {
           Task task = toDoList.get(toDoList.size()-1);
           id = task.getId() + 1;
        }

        Task task = new Task (id, heading, dateTime, completed, project);

        return task;
    }

    private void displayProjectsName (){
        for (int i = 0; i < Task.projects.length; i++) {
            System.out.println((i + 1) + " - " + Task.projects [i]);
        }
    }

    private String chooseProject (){

        System.out.println("Choose the number : ");
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine();
        int result = Integer.parseInt(input);
        return Task.projects[result-1];
        //cover this code by if statement so it will not crash

    }



}
