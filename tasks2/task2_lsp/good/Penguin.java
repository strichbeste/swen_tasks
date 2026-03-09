package good;

// penguin erbt von bird aber nicht von flyingbird
// kein lsp-bruch mehr: move() ist immer sicher aufrufbar
public class Penguin extends Bird {
    @Override
    public void move() {
        System.out.println("pinguin schwimmt");
    }
}
