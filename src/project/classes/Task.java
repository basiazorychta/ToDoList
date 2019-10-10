package project.classes;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.Date;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * This class holds information about the User tasks.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class Task implements Serializable {

    public static String projects [] = {"EDUCATION", "SHOPPING", "HOUSE", "HEALTH", "HOBBY"};

    private int id;
    private String heading;
    private Date datetime;
    private boolean completed;
    private String project;

    public Task(int id, String heading, Date datetime, boolean completed, String project) {
        this.id = id;
        this.heading = heading;
        this.datetime = datetime;
        this.completed = completed;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Date getDate() {
        return datetime;
    }

    public void setDate(Date datetime) {
        this.datetime = datetime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getProject() {
        return project;
    }

    public void setProject (String project){ this.project = project;}


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", \n title = '" + heading + '\'' +
                ", \n date time = " + datetime +
                ", \n completed = " + completed +
                ", \n project = '" + project + '\'' +
                '}';
    }
}
