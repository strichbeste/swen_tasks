package tasks1.task1_cpp_vs_java;

// basisklasse fuer alle formen – entspricht der abstrakten c++ basisklasse
public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // abstrakt – in c++: virtual double area() = 0;
    public abstract double area();

    // in java standardmaessig virtuell, in c++ braucht man explizit 'virtual'
    public String describe() {
        return "form: " + getClass().getSimpleName() + ", farbe: " + color;
    }
}
