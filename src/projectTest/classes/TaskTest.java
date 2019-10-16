package projectTest.classes;

import org.junit.jupiter.api.Test;
import project.classes.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void TestCreateTask() {
        Date date = new Date();
        Task task = new Task(1, "Doctor", date, true, "HOBBY");

        assertEquals(1, task.getId());
        assertEquals("Doctor", task.getHeading());
        assertEquals(true, task.isCompleted());
        assertEquals("HOBBY", task.getProject());

        task.setHeading("Cleaning");
        task.setCompleted(false);
        task.setProject("TRAVELLING");

        assertEquals("Cleaning", task.getHeading());
        assertEquals(false, task.isCompleted());
        assertEquals("TRAVELLING", task.getProject());

    }

}