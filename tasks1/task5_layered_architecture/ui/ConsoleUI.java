package ui;

import model.Task;
import service.TaskService;
import repository.InMemoryTaskRepository;

// ui-schicht (presentation layer)
// nur fuer ein-/ausgabe zustaendig
// kennt den service aber nicht repository oder datenbank
public class ConsoleUI {
    public static void main(String[] args) {
        // aufbau von unten nach oben: repository -> service -> ui
        TaskService service = new TaskService(new InMemoryTaskRepository());

        // tasks erstellen
        service.createTask("projekt abgeben");
        service.createTask("praesentationen vorbereiten");
        service.createTask("unit tests schreiben");

        // task erledigen
        service.completeTask(1);

        // ausgabe
        System.out.println("--- meine tasks ---");
        for (Task t : service.getAllTasks()) {
            System.out.println(t);
        }
    }
}
