package tasks2.task2_lsp.bad;

// LSP VERLETZUNG: penguin kann nicht fliegen, wirft exception
// caller erwartet dass fly() funktioniert -> lsp gebrochen
public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("pinguine koennen nicht fliegen!");
    }
}
