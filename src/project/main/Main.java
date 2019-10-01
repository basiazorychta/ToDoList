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

        todo.printAllTasks();




    }
}
