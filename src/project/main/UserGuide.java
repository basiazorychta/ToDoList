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

    /**
     * Creating final int helps to use same value in every part of the project.
     */
    public static final int SHOW_TASK_LIST_BY_DATE = 1;
    public static final int SHOW_TASK_LIST_BY_PROJECT = 2;
    public static final int ADD_NEW_TASK = 3;
    public static final int EDIT_TASK = 4;
    public static final int SAVE_AND_QUIT = 5;

    public static final int UPDATE_TASK = 1;
    public static final int MARK_AS_DONE = 2;
    public static final int REMOVE_TASK = 3;
    public static final int BACK_TO_MAIN_MENU = 4;

    private ToDo todo;

    /**
     * Constructor
     * @param fileName
     * @throws IOException
     */
    public UserGuide(String fileName) throws IOException {
       todo = new ToDo(fileName);
    }

    /**
     * Display Main Menu.
     * User by choosing the # choose specific action
     */
    private void showMainManu(){
        System.out.println("\nWelcome to ToDoLy\n" +
                "You have "+ todo.getCountOfRemainingTasks() +" tasks todo and "+todo.getCountOfCompletedTasks()+" tasks are done!\n" +
                "Pick an option:\n" +
                "("+SHOW_TASK_LIST_BY_DATE+") Show Task List by date\n" +
                "("+SHOW_TASK_LIST_BY_PROJECT+") Show Task List by project\n" +
                "("+ADD_NEW_TASK+") Add New Task\n" +
                "("+EDIT_TASK+") Edit Task (update, mark as done, remove)\n" +
                "("+SAVE_AND_QUIT+") Save and Quit\n");
    }

    /**
     * This method takes input from user to select option from main menu
     * User choose # only from SHOW_TASK_BY_DATE till SAVE_AND_QUIT
     * User gets error message if # is invalid
     */
    public void takeUserInputForMainTasks() {

        int input;

        while (true) {
            showMainManu();
            input = Utility.takeUserInput("Choose the number : ");

            if (input >= SHOW_TASK_LIST_BY_DATE && input <= SAVE_AND_QUIT) {

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


    /**
     * Method helps user to choose only specific part of Main Menu by adding the #
     * User is receiving error message if # is not correct
     * @param input
     */
    private void selectOption (int input){

        switch (input) {

            case SHOW_TASK_LIST_BY_DATE :
                todo.printAllTasksByDate();
                break;
            case SHOW_TASK_LIST_BY_PROJECT :
                todo.printAllTasksByProject();
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

    /**
     * Display Sub Menu
     * User can choose the specific activity
     */
    private void showSubMenu(){
        System.out.println("("+UPDATE_TASK+") Update Task \n" +
                "("+MARK_AS_DONE+") Mark As Done Task \n" +
                "("+REMOVE_TASK+") Remove Task \n" +
                "("+BACK_TO_MAIN_MENU+") Back to Main Menu");
    }

    /**
     * This method takes input from user to select option from sub menu
     * User choose # only from UPDATE_TASK till BACK_TO_MAIN_MENU
     * User gets error message if # is invalid.
     */
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

    /**
     * Method helps user to choose only specific part of Sub Menu by adding the #
     * User is receiving error message if # is not correct
     * @param input
     */
    private void selectEditOption (int input){

        todo.printAllTasksByProject();

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
