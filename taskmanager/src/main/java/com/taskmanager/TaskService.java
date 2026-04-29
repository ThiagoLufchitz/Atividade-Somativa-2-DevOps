package com.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public boolean completeTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.complete();
                return true;
            }
        }
        return false;
    }

    public boolean removeTask(String title) {
        return tasks.removeIf(task -> task.getTitle().equals(title));
    }

    public Task findTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }
}