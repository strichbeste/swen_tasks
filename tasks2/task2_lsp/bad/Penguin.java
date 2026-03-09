package bad;

// verletzung: penguin erbt fly() aber kann nicht fliegen
// wirft exception -> bricht lsp: caller erwartet dass fly() funktioniert
public class Penguin extends Bird {
    @Override
    public void fly() {
        // lsp verletzung: statt fliegen zu koennen wird exception geworfen
        throw new UnsupportedOperationException("pinguine koennen nicht fliegen!");
    }
}
