package service;

import model.Task;
import repository.TaskRepository;
import java.util.List;

// service-schicht (business logic layer)
// enthaelt die eigentliche fachlogik
// kennt das repository aber nicht das ui
public class TaskService {
    private TaskRepository repo;
    private int nextId = 1;

    // dependency injection: repository wird von aussen reingegeben
    // -> leicht testbar, leicht austauschbar
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

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

    public List<Task> getAllTasks() {
        return repo.findAll();
    }
}
