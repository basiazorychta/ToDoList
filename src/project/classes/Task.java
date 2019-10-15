package project.classes;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * This class holds information about the User task.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class Task implements Serializable {

    /**
     * Array with a projects name which user can choose from.
     */
    public static String projects [] = {"EDUCATION", "SHOPPING", "HOUSE", "HEALTH", "HOBBY"};

    // Fields
    private int id;
    private String heading;
    private Date datetime;
    private boolean completed;
    private String project;

    /**
     * Constructor
     * @param id
     * @param heading
     * @param datetime
     * @param completed
     * @param project
     */
    public Task(int id, String heading, Date datetime, boolean completed, String project) {
        this.id = id;
        this.heading = heading;
        this.datetime = datetime;
        this.completed = completed;
        this.project = project;
    }

    /**
     * The getId method returns a Task object's id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * The getHeading method returns a Task object's heading
     * @return heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * The setHeading method stores a value in the heading field.
     * @param heading
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * The getDate method returns a Task object's datetime
     * @return datetime
     */
    public Date getDate() {
        return datetime;
    }

    /**
     * The setDate method stores a value in the datetime field.
     * @param datetime
     */
    public void setDate(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * The boolean method returns a Task object's completed
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * The setCompleted method stores a value in the completed field.
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * The getProject method returns a Task object's project
     * @return project
     */
    public String getProject() {
        return project;
    }

    /**
     * The setProject method stores a value in the project field.
     * @param project
     */
    public void setProject (String project){ this.project = project;}


    /**
     * Display the object's taskId, projectName, taskTitle, task datetime, completed.
     * @return taskId + projectName + taskTitle + completed + taskDate
     */
    @Override
    public String toString() {
        String taskId = "Task ID : " + id + "\n";
        String projectName = "Project : " + project + "\n";
        String taskTitle = "Title : " + heading + "\n";

        String pattern = "dd-MM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String taskDate = "Due date : " + simpleDateFormat.format (datetime) + "\n";

        String completed = "Status : " + (isCompleted() ? "completed" : "in progress") + "\n";

        return taskId + projectName + taskTitle + completed + taskDate;
    }
}
