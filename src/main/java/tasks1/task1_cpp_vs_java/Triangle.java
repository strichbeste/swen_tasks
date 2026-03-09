package tasks1.task1_cpp_vs_java;

public class Triangle extends Shape {
    private double base, height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (base * height) / 2.0;
    }
}
