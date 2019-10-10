package project.main;

import project.classes.Utility;
import project.logic.ToDo;

import java.io.IOException;

/**
 * This class is part of the "ToDo List" application.
 * "ToDo List" is an application which help user to not forget what needs to be done.
 *
 * This UserGuide Class is an interface between user and application.
 * This Class shows all menus and submenus where user can choose different options.
 *
 * @author  Barbara Zorychta
 * @version 2019.10.10
 */

public class UserGuide {

    public static final int SHOW_TASK_LIST = 1;
    public static final int ADD_NEW_TASK = 2;
    public static final int EDIT_TASK = 3;
    public static final int SAVE_AND_QUIT = 4;

    public static final int UPDATE_TASK = 1;
    public static final int MARK_AS_DONE = 2;
    public static final int REMOVE_TASK = 3;
    public static final int BACK_TO_MAIN_MENU = 4;

    private ToDo todo;

    public UserGuide(String fileName) throws IOException {
       todo = new ToDo(fileName);
    }

    private void showMainManu(){
        System.out.println("\nWelcome to ToDoLy\n" +
                "You have "+ todo.getCountOfRemainingTasks() +" tasks todo and "+todo.getCountOfCompletedTasks()+" tasks are done!\n" +
                "Pick an option:\n" +
                "("+SHOW_TASK_LIST+") Show Task List (by date or project)\n" +
                "("+ADD_NEW_TASK+") Add New Task\n" +
                "("+EDIT_TASK+") Edit Task (update, mark as done, remove)\n" +
                "("+SAVE_AND_QUIT+") Save and Quit\n");
    }

    public void takeUserInputForMainTasks() {

        int input;

        while (true) {
            showMainManu();
            input = Utility.takeUserInput("Choose the number : ");

            if (input >= SHOW_TASK_LIST && input <= SAVE_AND_QUIT) {

                selectOption(input);
                if (input == SAVE_AND_QUIT){
                    System.out.println("Your records are saved. See You next time...");
                    break;
                }
            } else {
                System.out.println(input + " is an invalid input\n");
            }
        }
    }

    private void selectOption (int input){

        switch (input) {

            case SHOW_TASK_LIST :
                todo.printAllTasks();
                break;
            case ADD_NEW_TASK:
                todo.addTaskIntoTheList(todo.createTask());
                break;
            case EDIT_TASK:
                takeUserInputForEditTasks();
                break;
            case SAVE_AND_QUIT:
                todo.saveFile();
                break;
            default:
                System.out.println ("Invalid input");
        }
    }

    private void showSubMenu(){
        System.out.println("("+UPDATE_TASK+") Update Task \n" +
                "("+MARK_AS_DONE+") Mark As Done Task \n" +
                "("+REMOVE_TASK+") Remove Task \n" +
                "("+BACK_TO_MAIN_MENU+") Back to Main Menu");
    }

    private void takeUserInputForEditTasks() {

        int result;

        while (true) {
            showSubMenu();
            result = Utility.takeUserInput("Choose the number : ");

            if (result >= UPDATE_TASK && result <= BACK_TO_MAIN_MENU) {
                break;
            }
            System.out.println(result + " is an invalid input");
        }
        if(result != BACK_TO_MAIN_MENU){
            selectEditOption(result);
        }
    }

    private void selectEditOption (int input){

        todo.printAllTasks();

        switch (input) {
            case UPDATE_TASK :
            {
                int id = Utility.takeUserInput("\nEnter Task Id to Update : ");
                todo.updateTask(id);
            }
                break;
            case MARK_AS_DONE:
            {
                int id = Utility.takeUserInput ("\nEnter Task Id to Mark As Done : ");

                if (todo.markTaskAsDone(id)){
                    System.out.println("id # " + id + " - Task is set as completed!");
                }else{
                    System.out.println("id # " + id + " - Could not update the Task!");
                }
            }
                break;
            case REMOVE_TASK:
            {
                int id = Utility.takeUserInput("\nEnter Task Id to Remove : ");
                if (todo.removeTask(id)){
                    System.out.println("id # " + id + " - Task has been removed!");
                }else{
                    System.out.println("id # " + id + " - Could not remove!");
                }
            }
                break;
            default:
                System.out.println ("Invalid input");
        }
    }
}
