package com.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    // ── Testes de adição ──────────────────────────────────────────────────────

    @Test
    void shouldAddTask() {
        service.addTask("Teste");

        assertEquals(1, service.listTasks().size());
    }

    @Test
    void shouldAddMultipleTasks() {
        service.addTask("Tarefa 1");
        service.addTask("Tarefa 2");
        service.addTask("Tarefa 3");

        assertEquals(3, service.listTasks().size());
    }

    @Test
    void shouldStartWithEmptyList() {
        assertTrue(service.listTasks().isEmpty());
    }

    // ── Testes de busca ───────────────────────────────────────────────────────

    @Test
    void shouldFindTask() {
        service.addTask("Java");

        assertNotNull(service.findTask("Java"));
    }

    @Test
    void shouldReturnNullWhenTaskNotFound() {
        assertNull(service.findTask("Inexistente"));
    }

    // ── Testes de conclusão ───────────────────────────────────────────────────

    @Test
    void shouldCompleteTask() {
        service.addTask("Estudar");
        service.completeTask("Estudar");

        assertTrue(service.findTask("Estudar").isCompleted());
    }

    @Test
    void shouldReturnFalseWhenCompletingNonexistentTask() {
        assertFalse(service.completeTask("Nada"));
    }

    @Test
    void shouldNotCompleteAlreadyCompletedTask() {
        service.addTask("DevOps");
        service.completeTask("DevOps");
        boolean result = service.completeTask("DevOps");

        assertTrue(result);
        assertTrue(service.findTask("DevOps").isCompleted());
    }

    // ── Testes de remoção ─────────────────────────────────────────────────────

    @Test
    void shouldRemoveTask() {
        service.addTask("Remover");
        service.removeTask("Remover");

        assertEquals(0, service.listTasks().size());
    }

    @Test
    void shouldReturnFalseWhenRemovingNonexistentTask() {
        assertFalse(service.removeTask("Fantasma"));
    }
}