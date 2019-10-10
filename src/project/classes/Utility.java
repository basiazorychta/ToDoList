package project.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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



    public static Date createDateTime () {

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

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            dateFormat.setLenient(false);

            try {
                date = dateFormat.parse(year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":00");

                Date today = new Date();


                if (date.before(today)) {
                    System.out.println("Date is invalid... Re-enter");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Date is invalid... Re-enter");
            }

        }

        return date;
    }

    public static int takeUserInput (String message){

        System.out.println(message);
        Scanner scanner = new Scanner (System.in);
        String number = scanner.nextLine();
        int id = Integer.parseInt(number);

        return id;
    }
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

    public static ArrayList<Task> readFile (String fileName) throws IOException {

        ArrayList<Task> taskslist = new ArrayList<>();
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
            inputStream.close();
            objectInputStream.close();
        }
        return taskslist;
    }


}
