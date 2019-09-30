package project.logic;


import project.classes.Task;
import project.classes.Utility;

import java.text.SimpleDateFormat;
import java.util.*;

public class ToDo {

    //private ArrayList <Task> toDoList;
    private HashMap <String, ArrayList<Task>> taskCalendar;

    public ToDo() {
        //toDoList = new ArrayList<>();
        taskCalendar = new HashMap<>();
    }
    private ArrayList <Task> getTasksList (String key){
        return taskCalendar.get(key);
    }
    public void printAllTasks (){
        for (Map.Entry mi : taskCalendar.entrySet()) {
            ArrayList <Task> toDoList = (ArrayList<Task>) mi.getValue();
            for (Task task : toDoList) {
                System.out.println(task.toString());
            }
            System.out.println("========");
        }
    }
    public void addTaskIntoTheList (Task task){
        String key = Utility.generateAKey(task.getDate());
        ArrayList <Task> toDoList = taskCalendar.get(key);
        if (toDoList != null){
            toDoList.add(task);
        }else {
            toDoList = new ArrayList<>();
            toDoList.add(task);
        }
        taskCalendar.put(key, toDoList);
    }

    public Task createTask (){
        Scanner reader = new Scanner (System.in);
        System.out.println("Task detail:");

        System.out.println("Enter heading of your task:");
        String heading = reader.nextLine();

        System.out.println("Enter date and time of your task:");
        Date dateTime = Utility.createDateTime();

        boolean completed = false;

        System.out.println("Enter the description of your task:");
        String description = reader.nextLine();

        String key = Utility.generateAKey(dateTime);

        ArrayList <Task> toDoList = getTasksList(key);

        int id;
        if (toDoList == null || toDoList.size()== 0){
            id = 1;
        }else {
           Task task = toDoList.get(toDoList.size()-1);
           id = task.getId() + 1;
        }

        Task task = new Task (id, heading, dateTime, completed, description);

        return task;
    }



}
