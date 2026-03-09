package tasks1.task5_layered_architecture.repository;

import tasks1.task5_layered_architecture.model.Task;
import java.util.*;

// in-memory implementierung – austauschbar gegen db-implementierung
public class InMemoryTaskRepository implements TaskRepository {
    private Map<Integer, Task> store = new HashMap<>();

    @Override public void save(Task task)        { store.put(task.getId(), task); }
    @Override public Task findById(int id)       { return store.get(id); }
    @Override public List<Task> findAll()        { return new ArrayList<>(store.values()); }
    @Override public void delete(int id)         { store.remove(id); }
}
