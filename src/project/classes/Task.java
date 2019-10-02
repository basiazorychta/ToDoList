package project.classes;

import java.util.Date;

public class Task {

    public static String projects [] = {"EDUCATION", "SHOPPING", "HOUSE", "HEALTH", "TRAVELLING"};

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
