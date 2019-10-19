package projectTest.classes;

import org.junit.jupiter.api.Test;
import project.classes.Task;
import project.classes.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void createDateTime() {

        String year = "2019";
        String month = "12";
        String day = "20";
        String hour = "00";
        String minutes = "59";

        Date date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNotNull(date);

        year = "2018";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

        year = "2020";
        month = "13";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

        month = "11";
        day = "0";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

        day = "10";
        hour = "25";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

        hour = "20";
        minutes = "-10";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

        minutes = "65";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

    }

    @Test
    void testDateForLeapYear (){

        String year = "2020";
        String month = "02";
        String day = "29";
        String hour = "19";
        String minutes = "50";

        Date date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNotNull(date);

        year = "2021";

        date = Utility.createDateTime(year, month, day, hour, minutes);
        assertNull(date);

    }

    @Test
    void saveFile() {

        String fileName = "DataBase_Test/Test_Records.txt";

        Date date = new Date();
        Task task = new Task(1, "Doctor", date, true, "HOBBY");

        ArrayList <Task> list = new ArrayList<>();
        list.add(task);
        boolean result = Utility.saveFile(fileName, list);
        assertTrue(result);

        fileName = "Folder_Does_Not_Exist/Test_Records.txt";
        result = Utility.saveFile(fileName, list);
        assertFalse(result);

    }

    @Test
    void readFile() throws IOException {

        String fileName = "DataBase_Test/Test_Records.txt";

        Date date = new Date();
        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, true, "HOBBY");

        ArrayList <Task> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);

        boolean result = Utility.saveFile(fileName, list);
        assertTrue(result);

        ArrayList<Task> receivedlist = Utility.readFile(fileName);

        assertEquals(list.size(), receivedlist.size());
        assertEquals(list.get(0).getId(), receivedlist.get(0).getId());
        assertNotEquals(list.get(1).getId(), receivedlist.get(0).getId());

        fileName = "Folder_Does_Not_Exist/Test_Records.txt";
        receivedlist = Utility.readFile(fileName);
        assertEquals (0,receivedlist.size());
    }

    @Test
    void testNameComparator (){

        Date date = new Date();
        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");
        Task task2 = new Task(2, "Doctor", date, true, "TRAVELING");
        Task task3 = new Task(3, "Doctor", date, true, "ABC");

        ArrayList <Task> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        list.add(task3);

        Collections.sort(list, Utility.NameComparator);
        assertEquals(3,list.get(0).getId());
        assertEquals(1,list.get(1).getId());
        assertEquals(2,list.get(2).getId());
    }

    @Test
    void testDateComparator (){

        String year = "2025";
        String month = "12";
        String day = "20";
        String hour = "00";
        String minutes = "59";

        Date date = Utility.createDateTime(year, month, day, hour, minutes);
        Task task1 = new Task(1, "Doctor", date, true, "HOBBY");

        year = "2019";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        Task task2 = new Task(2, "Doctor", date, true, "TRAVELING");

        year = "2020";
        date = Utility.createDateTime(year, month, day, hour, minutes);
        Task task3 = new Task(3, "Doctor", date, true, "ABC");

        ArrayList <Task> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        list.add(task3);

        Collections.sort(list, Utility.DateComparator);
        assertEquals(1,list.get(2).getId());
        assertEquals(2,list.get(0).getId());
        assertEquals(3,list.get(1).getId());
    }

}