package com.gboz.javaworkout.TasksOrganizer;

/**
 * Created by Grzegorz on 01.11.2016.
 */
public class Task implements TaskInterface{

    private int id = 0;
    private String name;
    private int time;

    Task(int i, String n, int t) {
        this.id = i;
        this.name = n;
        this.time = t;
    }

    @Override
    public String EditName(String n) {
        this.name = n;
        return n;
    }

    @Override
    public int EditTime(int t) {
        this.time = t;
        return t;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
