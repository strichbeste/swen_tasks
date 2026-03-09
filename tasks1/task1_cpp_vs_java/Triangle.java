// dreieck – erbt von shape
public class Triangle extends Shape {
    private double base, height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        // formel: (basis * hoehe) / 2
        return (base * height) / 2.0;
    }
}
