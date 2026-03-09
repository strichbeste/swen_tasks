package tasks1.task5_layered_architecture.model;

// model-schicht: nur daten, keine db, kein ui
public class Task {
    private int id;
    private String title;
    private boolean done;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public boolean isDone()     { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return "[" + (done ? "x" : " ") + "] " + title;
    }
}
