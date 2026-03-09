package tasks1.task5_layered_architecture.repository;

import tasks1.task5_layered_architecture.model.Task;
import java.util.List;

// data access layer: interface kapselt datenzugriff
// kann spaeter gegen postgres-implementierung ausgetauscht werden
public interface TaskRepository {
    void save(Task task);
    Task findById(int id);
    List<Task> findAll();
    void delete(int id);
}
