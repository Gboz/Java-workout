package com.gboz.javaworkout.TasksOrganizer;

/**
 * Created by Grzegorz on 01.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Task task1 = new Task(1, "Task 1", 1);
        Task task2 = new Task(2, "Task 2", 2);
        Task task3 = new Task(3, "Task 3", 1);

        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);

        task1.EditName(task1.getName() + " test");
        task1.EditTime(3);

        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
    }
}
