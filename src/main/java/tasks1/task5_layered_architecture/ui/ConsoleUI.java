package tasks1.task5_layered_architecture.ui;

import tasks1.task5_layered_architecture.model.Task;
import tasks1.task5_layered_architecture.repository.InMemoryTaskRepository;
import tasks1.task5_layered_architecture.service.TaskService;

// presentation layer: nur ein-/ausgabe, kennt service aber nicht repository
public class ConsoleUI {
    public static void main(String[] args) {
        // aufbau: repository -> service -> ui
        TaskService service = new TaskService(new InMemoryTaskRepository());

        service.createTask("projekt abgeben");
        service.createTask("praesentationen vorbereiten");
        service.createTask("unit tests schreiben");
        service.completeTask(1);

        System.out.println("--- meine tasks ---");
        for (Task t : service.getAllTasks()) {
            System.out.println(t);
        }
    }
}
