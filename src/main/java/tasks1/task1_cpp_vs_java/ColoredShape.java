package tasks1.task1_cpp_vs_java;

// zeigt einfachvererbung in java vs. mehrfachvererbung in c++
public class ColoredShape extends Shape {
    private int opacity;

    public ColoredShape(String color, int opacity) {
        super(color);
        this.opacity = opacity;
    }

    @Override
    public double area() { return 0; }

    @Override
    public String describe() {
        return super.describe() + ", deckkraft: " + opacity + "%";
    }
}
