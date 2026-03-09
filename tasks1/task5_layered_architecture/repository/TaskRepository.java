package repository;

import model.Task;
import java.util.List;

// repository-schicht (data access layer)
// kapselt datenzugriff – ui und service wissen nicht wie daten gespeichert werden
// interface ermoeglicht spaeteres austauschen (z.b. von in-memory zu postgres)
public interface TaskRepository {
    void save(Task task);
    Task findById(int id);
    List<Task> findAll();
    void delete(int id);
}
