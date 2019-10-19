# ToDoList


## Specification - Project Brief:
=================

Task is to build a todo list application. The application allows a user to:
  * create new tasks, 
  * assign tasks a title and due date, and 
  * choose a project for that task to belong to. 

The user is be able to:
  + edit tasks, 
  + mark as done tasks or 
  + remove tasks. 

The user can also quit and save the current task list to file, and then restart the application with the former state restored. 

## The User Guide is working according to:
=================

**Welcome to ToDoLy**
-------------

```
You have X tasks todo and Y tasks are done!

Pick an option:
(1) Show Task List by date
(2) Show Task List by project
(3) Add New Task
(4) Edit Task (update, mark as done, remove):
     (1) Update Task
     (2) Mark Task As Done
     (3) Remove Task
     (4) Back to Main Menu
(5) Save and Quit
```


## Requirements:
=================

### The solution achieve the following requirements:

  - Model a task with a task title, due date, status and project,
  - Display a collection of tasks that is able to sorted both by date and project,
  - Support the ability to add, edit, mark as done, and remove tasks,
  - Support a text-based user interface,
  - Load and save task list to file.
  
  
  
 # User Guide
 

Let’s start using To Do List application.
---------------------------------------------
-----------------------------------------------

Welcome to ToDoLy
-------------------------------------

```javascript

You have X tasks todo and Y tasks are done!
Pick an option:
1 Show Task List by date 
2 Show Task List by project
3 Add New Task
4 Edit Task (update, mark as done, remove)
5 Save and Quit 

```
 

#### (1) In First step: User by choosing #3 can start creating new Task in To Do List:

```javascript

  Task detail:
  Enter heading of your task: IP Project

```

#### (2) By date and time user is adding due date:

```javascript

  Enter date and time of your task:
  Enter year: [example 2019]: 2019
  Enter month: [between: 01-12]: 10
  Enter day: [between: 01-31]: 25
  Enter hour: [between: 00-23]: 17
  Enter minute: [between: 00-59]: 00

```
 

#### (2b) If – by mistake User will add date before day when new task is creating – No problem.
#### User will receive information and will be able to fix date.

```javascript

  Enter date and time of your task:
  Enter year: [example 2019]: 2019
  Enter month: [between: 01-12]: 10
  Enter day: [between: 01-31]: 10
  Enter hour: [between: 00-23]: 10
  Enter minute: [between: 00-59]: 00

  Invalid date

  Enter year: [example 2019]: 
  Enter month: [between: 01-12]: 
  Enter day: [between: 01-31]: 
  Enter hour: [between: 00-23]: 
  Enter minute: [between: 00-59]: 

```

#### (3) Next step – choosing Project form list:

```javascript

Select Project type from the list: 1 – 5
1- EDUCATION
2- SHOPPING
3- HOUSE
4- HEALTH
5- HOBBY
```
 

#### After adding Project # from the list User is receiving `New Task`

 ```javascript
Task added successfully....

 Task ID: 7
 Project: EDUCATION
 Title: IP Project
 Status: In progres
 Due date: 25-10-2019 17:00
 ```

#### (4) By pressing # 5 User can Save all task and leave `ToDoLy application`

 ```javascript
  Your records are saved. See You next time
  ```



# User Guide – Task Modification
---------------------------------------------------
----------------------------------------------------

First step is same like at the beginning: 
User see `Main Menu` with info about tasks which need to be done and tasks which are already done but not removed from the `To Do List` 

 
Welcome to ToDoLy
--------------------------------------------------------

```javascript

You have 6 tasks todo and 2 tasks are done!
Pick an option:
1 Show Task List by date 
2 Show Task List by project
3 Add New Task
4 Edit Task (update, mark as done, remove)
5 Save and Quit 

```

#### (1.1) By pressing # 1 in `Main Menu`, user can see all tasks sorted by `date` 

 
 ```javascript
 
 Choose the number : 
 1

 Task ID : 4
 Project : SHOPPING
 Title : Shopping stuff
 Status : completed
 Due date : 15-10-2019 12:12
 
 Task ID : 7
 Project : EDUCATION
 Title : IP Project
 Status : in progress
 Due date : 25-10-2019 17:00

Task ID : 6
Project : HOUSE
Title : baking
Status : completed
Due date : 10-11-2019 12:00

Task ID : 8
Project : SHOPPING
Title : Interview
Status : in progress
Due date : 20-11-2019 12:30

 ```


#### (2.1) By pressing # 2 in `Main Menu`, user can see all tasks which are sorted by `project` 

```javascript

 Choose the number : 
  2

  Task ID : 1
  Project : EDUCATION
  Title : Shopping
  Status : in progress
  Due date : 12-12-2019 12:12
  
  Task ID : 2
  Project : EDUCATION
  Title : Study
  Status : in progress
  Due date : 12-12-2019 12:12
  
  Task ID : 7
  Project : EDUCATION
  Title : IP Project
  Status : in progress
  Due date : 25-10-2019 17:00
  
  Task ID : 3
  Project : HOBBY
  Title : Party
  Status : in progress
  Due date : 31-12-2019 19:00
  
  Task ID : 5
  Project : HOBBY
  Title : Cinema
  Status : in progress
  Due date : 01-12-2019 20:00
  
  Task ID : 6
  Project : HOUSE
  Title : baking
  Status : completed
  Due date : 10-11-2019 12:00

 ```

#### (3) After pressing #4 user will go to `Sub Menu` where user can:
```python
1 - Update
2 - Mark task as done
3 - Remove
4 - Back to Main Menu
```

#### (4.1.1) Each task can be updated by pressing #1 in `Sub Menu`. System is showing all tasks.
#### By choosing `taskID` user is updating task. 
```javascript

Following steps from (1) - (3) from **Let’s start using To Do List application.**
user is updating task

```

#### (4.2.1) When task is done, by pressing #2, user can easy change status from `in progres` till `completed`
#### By choosing `taskID` user is changing status of task. 
```javascript

Enter Task Id to Mark As Done : 
8
id # 8 - Task is set as completed!

```
#### (4.3.1) Each task can be removed by pressing #3 in `Sub Menu`. System is showing all tasks.
By choosing `taskID` user is removing task from all list. 
```javascript         
Enter Task Id to Remove : 
8
id # 8 - Task has been removed!
```
#### (4.4.1) If user will come to `Sub Menu` by mistake...
#### No problem
#### Press #4 and will go back to `Main Menu`  
