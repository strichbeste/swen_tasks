package tasks2.task2_lsp.good;

public abstract class FlyingBird extends Bird {
    public void fly() { System.out.println(getClass().getSimpleName() + " fliegt"); }
    @Override public void move() { fly(); }
}
