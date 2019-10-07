package project.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

   
}
