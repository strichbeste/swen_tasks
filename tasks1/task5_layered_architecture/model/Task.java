package model;

// model-schicht (domain layer)
// enthaelt nur daten und geschaeftslogik, keine db und kein ui
public class Task {
    private int id;
    private String title;
    private boolean done;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.done = false;
    }

    // getter/setter – kein direkter zugriff auf felder (encapsulation)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return "[" + (done ? "x" : " "] + "] " + title;
    }
}
