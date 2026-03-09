package tasks1.task1_cpp_vs_java;

// kreis erbt von shape – in c++: class Circle : public Shape
public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color); // elternkonstruktor – in c++ in initialisierungsliste
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
