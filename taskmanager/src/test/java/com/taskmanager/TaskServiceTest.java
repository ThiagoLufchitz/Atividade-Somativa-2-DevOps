package com.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldAddTask() {
        TaskService service = new TaskService();

        service.addTask("Teste");

        assertEquals(1, service.listTasks().size());
    }

    @Test
    void shouldFindTask() {
        TaskService service = new TaskService();

        service.addTask("Java");

        assertNotNull(service.findTask("Java"));
    }

    @Test
    void shouldCompleteTask() {
        TaskService service = new TaskService();

        service.addTask("Estudar");
        service.completeTask("Estudar");

        assertTrue(service.findTask("Estudar").isCompleted());
    }

    @Test
    void shouldRemoveTask() {
        TaskService service = new TaskService();

        service.addTask("Remover");
        service.removeTask("Remover");

        assertEquals(0, service.listTasks().size());
    }

    @Test
    void shouldReturnFalseIfTaskNotFound() {
        TaskService service = new TaskService();

        assertFalse(service.completeTask("Nada"));
    }
}