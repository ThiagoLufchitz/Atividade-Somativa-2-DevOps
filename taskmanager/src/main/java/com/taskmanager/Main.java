package com.taskmanager;

public class Main {
    public static void main(String[] args) {

        TaskService service = new TaskService();

        service.addTask("Estudar Java");
        service.addTask("Fazer atividade");

        service.completeTask("Estudar Java");

        for (Task task : service.listTasks()) {
            System.out.println(task.getTitle() + " -> " + task.isCompleted());
        }
    }
}