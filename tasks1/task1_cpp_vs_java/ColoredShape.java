// erweiterung mit zusaetzlichem attribut – zeigt mehrfachvererbung vs. einzelvererbung
// in c++ wuerde man mehrfachvererbung nutzen: class ColoredShape : public Shape, public Printable
// in java: nur einfachvererbung bei klassen, mehrfach nur bei interfaces
public class ColoredShape extends Shape {
    private int opacity; // 0-100 prozent

    public ColoredShape(String color, int opacity) {
        super(color);
        this.opacity = opacity;
    }

    @Override
    public double area() {
        // abstrakte klasse muss implementiert werden – auch wenn kein sinnvoller wert
        return 0;
    }

    @Override
    public String describe() {
        return super.describe() + ", deckkraft: " + opacity + "%";
    }
}
