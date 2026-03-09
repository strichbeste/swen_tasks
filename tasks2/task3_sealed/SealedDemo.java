// sealed classes seit java 17
// erlaubt: explizit festlegen welche klassen erben duerfen
// vorteil: compiler weiss alle moeglichen subklassen -> vollstaendige switch-ausdruecke

// nur diese drei klassen duerfen Shape erweitern
public sealed class SealedDemo permits SealedDemo.Circle, SealedDemo.Rectangle, SealedDemo.Triangle {

    // nested klassen der einfachheit halber
    public static final class Circle extends SealedDemo {
        public double radius;
        public Circle(double r) { this.radius = r; }
    }

    public static final class Rectangle extends SealedDemo {
        public double w, h;
        public Rectangle(double w, double h) { this.w = w; this.h = h; }
    }

    public static final class Triangle extends SealedDemo {
        public double base, height;
        public Triangle(double b, double h) { this.base = b; this.height = h; }
    }

    // pattern matching switch – compiler prueft vollstaendigkeit
    // ohne sealed: default-zweig noetig, mit sealed: compiler warnt wenn ein typ fehlt
    public static double area(SealedDemo shape) {
        return switch (shape) {
            case Circle c    -> Math.PI * c.radius * c.radius;
            case Rectangle r -> r.w * r.h;
            case Triangle t  -> (t.base * t.height) / 2;
        };
    }

    public static void main(String[] args) {
        System.out.println(area(new Circle(5)));
        System.out.println(area(new Rectangle(4, 6)));
        System.out.println(area(new Triangle(3, 8)));
    }
}
