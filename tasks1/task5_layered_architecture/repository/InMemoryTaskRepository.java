package repository;

import model.Task;
import java.util.*;

// in-memory implementierung des repository-interfaces
// koennte spaeter durch PostgresTaskRepository ersetzt werden
public class InMemoryTaskRepository implements TaskRepository {
    // einfache hashmap als "datenbank"
    private Map<Integer, Task> store = new HashMap<>();

    @Override
    public void save(Task task) {
        store.put(task.getId(), task);
    }

    @Override
    public Task findById(int id) {
        return store.get(id);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(int id) {
        store.remove(id);
    }
}
