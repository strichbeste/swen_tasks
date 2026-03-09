package tasks2.task2_lsp.good;

// kein lsp-bruch: move() ist immer sicher aufrufbar
public class Penguin extends Bird {
    @Override public void move() { System.out.println("pinguin schwimmt"); }
}
