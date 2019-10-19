package projectTest.logic;

import org.junit.jupiter.api.Test;
import project.classes.Task;
import project.logic.ToDo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    @Test
    void addTaskIntoTheList() throws IOException {

        ToDo todo = new ToDo("DataBase_Test/File.txt");

        int expectedCount = todo.getTaskCount()+1;
        Date date = new Date();
        Task task = new Task(1, "Doctor", date, true, "HOBBY");

        todo.addTaskIntoTheList(task);
        int actualCount = todo.getTaskCount();

        assertEquals(expectedCount, actualCount);

    }

    @Test
    void removeTask() throws IOException {

        ToDo todo = new ToDo("DataBase_Test/File.txt");

        Date date = new Date();
        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, true, "HOBBY");
        Task task3 = new Task(3, "Doctor", date, true, "HOBBY");
        Task task4 = new Task(4, "Doctor", date, true, "HOBBY");

        todo.addTaskIntoTheList(task1);
        todo.addTaskIntoTheList(task2);
        todo.addTaskIntoTheList(task3);
        todo.addTaskIntoTheList(task4);

        int expectedCount = todo.getTaskCount()-1;

        boolean answer = todo.removeTask(2);
        assertTrue(answer);

        int actualCount = todo.getTaskCount();
        assertEquals(expectedCount, actualCount);

        answer = todo.removeTask(2);
        assertFalse(answer);

    }

    @Test
    void markTaskAsDone() throws IOException {

        ToDo todo = new ToDo("DataBase_Test/File.txt");

        Date date = new Date();
        Task task1 = new Task(1, "Doctor", date, false, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, false, "HOBBY");
        Task task3 = new Task(3, "Doctor", date, false, "HOBBY");
        Task task4 = new Task(4, "Doctor", date, false, "HOBBY");

        todo.addTaskIntoTheList(task1);
        todo.addTaskIntoTheList(task2);
        todo.addTaskIntoTheList(task3);
        todo.addTaskIntoTheList(task4);

        todo.markTaskAsDone(2);
        long actualCount = todo.getCountOfCompletedTasks();
        long expectedCount = 1;
        assertEquals(expectedCount, actualCount);

        todo.markTaskAsDone(3);
        actualCount = todo.getCountOfCompletedTasks();
        expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }


    @Test
    void getCountOfRemainingTasks() throws IOException {

        ToDo todo = new ToDo("DataBase_Test/File.txt");

        Date date = new Date();
        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, true, "HOBBY");
        Task task3 = new Task(3, "Doctor", date, true, "HOBBY");
        Task task4 = new Task(4, "Doctor", date, false, "HOBBY");

        todo.addTaskIntoTheList(task1);
        todo.addTaskIntoTheList(task2);
        todo.addTaskIntoTheList(task3);
        todo.addTaskIntoTheList(task4);


        long actualCount = todo.getCountOfRemainingTasks();
        long expectedCount = 1;
        assertEquals(expectedCount, actualCount);

    }

    @Test
    void generateTaskIdk() throws IOException {

        throw new UnsupportedOperationException("following test case is for public method");

        /*
        ToDo todo = new ToDo("DataBase_Test/File.txt");

        Date date = new Date();

        int expectedId = 1;
        int actualId = todo.generateTaskId();
        assertEquals(expectedId, actualId);

        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, true, "HOBBY");
        Task task3 = new Task(3, "Doctor", date, true, "HOBBY");
        Task task4 = new Task(20, "Doctor", date, false, "HOBBY");

        todo.addTaskIntoTheList(task1);
        todo.addTaskIntoTheList(task2);
        todo.addTaskIntoTheList(task3);
        todo.addTaskIntoTheList(task4);

        expectedId = 21;
        actualId = todo.generateTaskId();
        assertEquals(expectedId, actualId);
*/
    }
}