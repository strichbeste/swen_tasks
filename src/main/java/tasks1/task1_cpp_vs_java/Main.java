package tasks1.task1_cpp_vs_java;

public class Main {
    public static void main(String[] args) {
        // key unterschied: in java kein object slicing, alles per referenz
        // in c++ mit pointer/virtual noetig fuer dynamic dispatch
        Shape[] shapes = {
            new Circle("rot", 5.0),
            new Rectangle("blau", 4.0, 6.0),
            new Triangle("gruen", 3.0, 8.0),
            new ColoredShape("gelb", 80)
        };

        for (Shape s : shapes) {
            // dynamic dispatch automatisch – in c++ nur mit virtual + pointer
            System.out.println(s.describe() + " | flaeche: " + s.area());
        }
        // kein delete noetig – garbage collector raeumt auf
    }
}
