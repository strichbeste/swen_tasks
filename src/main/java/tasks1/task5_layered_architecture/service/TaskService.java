package tasks1.task5_layered_architecture.service;

import tasks1.task5_layered_architecture.model.Task;
import tasks1.task5_layered_architecture.repository.TaskRepository;
import java.util.List;

// business logic layer: fachlogik, kennt repository aber nicht ui
public class TaskService {
    private TaskRepository repo;
    private int nextId = 1;

    // dependency injection: repository wird reingegeben -> testbar
    public TaskService(TaskRepository repo) { this.repo = repo; }

    public Task createTask(String title) {
        Task t = new Task(nextId++, title);
        repo.save(t);
        return t;
    }

    public void completeTask(int id) {
        Task t = repo.findById(id);
        if (t == null) throw new IllegalArgumentException("task nicht gefunden: " + id);
        t.setDone(true);
        repo.save(t);
    }

    public List<Task> getAllTasks() { return repo.findAll(); }
}
