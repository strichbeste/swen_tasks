// einstiegspunkt – zeigt polymorphismus und unterschiede zur c++ laufzeit
public class Main {
    public static void main(String[] args) {
        // KEY UNTERSCHIED: in java kein 'new' auf stack, alles am heap mit garbage collector
        // in c++ koennte man: Shape s = Circle(...) auf dem stack anlegen (object slicing!)
        // in java: immer per referenz, kein object slicing moeglich
        Shape[] shapes = {
            new Circle("rot", 5.0),
            new Rectangle("blau", 4.0, 6.0),
            new Triangle("gruen", 3.0, 8.0),
            new ColoredShape("gelb", 80)
        };

        for (Shape s : shapes) {
            // dynamic dispatch – in c++ nur mit virtual + pointer/referenz
            // in java immer automatisch
            System.out.println(s.describe() + " | flaeche: " + s.area());
        }

        // KEY UNTERSCHIED: kein delete/destruktor noetig
        // garbage collector raeumt auf
        // in c++ muesste man: delete[] shapes oder smart pointers nutzen
    }
}
