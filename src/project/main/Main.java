package project.main;

import java.io.IOException;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class Main {

    public static void main(String[] args) throws IOException {

        // file location
        String fileName = "DataBase/TasksListRecords.obj";

        UserGuide userManual = new UserGuide(fileName);
        userManual.takeUserInputForMainTasks();

    }
}
