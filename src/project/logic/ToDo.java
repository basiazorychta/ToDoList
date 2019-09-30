package project.logic;


import project.classes.Task;

import java.text.SimpleDateFormat;
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

    public Task addTask (){
        Scanner reader = new Scanner (System.in);
        System.out.println("Task detail:");

        System.out.println("Enter heading of your task:");
        String heading = reader.nextLine();

        System.out.println("Enter date and time of your task:");
        Date dateTime = createDateTime();

        boolean completed = false;

        System.out.println("Enter the description of your task:");
        String description = reader.nextLine();

        int id;

        if (toDoList.size()== 0){
            id = 1;
        }else {
           Task task = toDoList.get(toDoList.size()-1);
           id = task.getId() + 1;
        }

        Task task = new Task (id, heading, dateTime, completed, description);

        return task;
    }

    private Date createDateTime () {

        Date date = null;

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter year: [example: 2019]");
        String year = scanner.nextLine();

        System.out.println("Enter month: [between: 01-12]");
        String month = scanner.nextLine();

        System.out.println("Enter day: [between: 01-31]");
        String day = scanner.nextLine();

        System.out.println("Enter hour: [between: 00-23]");
        String hours = scanner.nextLine();

        System.out.println("Enter minute: [between: 00-59]");
        String minutes = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateFormat.setLenient(false);

        try {
            date = dateFormat.parse(year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":00");

            Date today = new Date ();

            if (date.before(today)){
                throw new Exception ("Date should be in future. Invalid date!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}
