package project.main;


import project.classes.Task;
import project.logic.ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ToDo todo = new ToDo();
        Task task = todo.createTask();
        todo.addTaskIntoTheList(task);
        task = todo.createTask();
        todo.addTaskIntoTheList(task);
        //task = todo.createTask();
        //todo.addTaskIntoTheList(task);

        todo.printAllTasks();

        System.out.println("\nEnter Task Id to Update : ");
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine();
        int id = Integer.parseInt(input);

        //todo.markTaskAsDone(id);


        todo.updateTask(id);

        todo.printAllTasks();




    }
}
