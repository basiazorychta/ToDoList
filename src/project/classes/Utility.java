package project.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * This Utility Class contains different helper methods.
 * For example: read and write a file, take input from the user and convert the date format.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class Utility {

    /**
     * This method creates the date object.
     * User is not able to add date before current day.
     * If date before today will be added, user will receive an error message
     * @param year
     * @param month
     * @param day
     * @param hours
     * @param minutes
     * @return Date
     */
    public static Date createDateTime (String year, String month, String day, String hours, String minutes) {

        Date date = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        dateFormat.setLenient(false);

        try {

            date = dateFormat.parse(year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":00");

            Date today = new Date();

            if (date.before(today)) {
                throw new Exception();
            }

        } catch (Exception e) {
            date = null;
        }

        return date;
    }

    /**
     * This method takes input from the user to create a date object.
     * If date or time is in invalid format, user will receive an error message
     * @return Date
     */
    public static Date getDateAndTime () {

        Date date = null;

        while (true) {

            Scanner scanner = new Scanner(System.in);
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

            date = createDateTime (year, month, day, hours, minutes);

            if (date == null) {
                System.out.println("Invalid date");
            } else {
                break;
            }
        }

        return date;
    }

    /**
     * This method takes input as Integer.
     * If input is other than Integer user will receive an error message
     * @param message
     * @return id
     */
    public static int takeUserInput (String message){

        int id = 0;

        while (true) {

            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();

            try {
                id = Integer.parseInt(number);
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input. Only numbers");
            }
        }
        return id;
    }

    /**
     * This method creates a binary file and writes the contents of an Array list to the file.
     * If file is saved successfully the method will return true otherwise false
     * @param fileName
     * @param taskslist
     * @return boolean
     */
    public static boolean saveFile (String fileName, ArrayList<Task> taskslist){

        boolean result = false;
        FileOutputStream outputStream;
        ObjectOutputStream objectOutputStream;

        try{

            outputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(outputStream);

            for (Task task : taskslist) {
                objectOutputStream.writeObject(task);
            }
            outputStream.close();
            objectOutputStream.close();

            result = true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    /**
     * This method opens a binary file, reads it and loads the file contents to the Array List and returns the list
     * @param fileName
     * @return ArrayList
     * @throws IOException
     */
    public static ArrayList<Task> readFile (String fileName) throws IOException {

        ArrayList<Task> taskslist = new ArrayList<>();

        File file = new File (fileName);

        if (!file.exists()){
            return taskslist;
        }
        FileInputStream inputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            inputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(inputStream);

            Object object = null;

            while (true){
                object = objectInputStream.readObject();

                if (object instanceof Task){
                    taskslist.add((Task) object);
                }
            }
        }
        catch (Exception e){
        }
        finally {
            if(inputStream != null)
                inputStream.close();

            if(objectInputStream != null)
                objectInputStream.close();
        }
        return taskslist;
    }

    /**
     * Helper function to sort the list by project name
     */
    public static Comparator<Task> NameComparator = new Comparator<Task>() {

        @Override
        public int compare(Task task1, Task task2) {
            String project1 = task1.getProject();
            String project2 = task2.getProject();

            return project1.compareTo(project2);
        }
    };

    /**
     * Helper function to sort the list by task date
     */
    public static Comparator<Task> DateComparator = new Comparator<Task>() {

        @Override
        public int compare(Task task1, Task task2) {
            Date date1 = task1.getDate();
            Date date2 = task2.getDate();

            return date1.compareTo(date2);
        }
    };
}
