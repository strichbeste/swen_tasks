package tasks2.task3_sealed;

// sealed classes seit java 17: nur explizit erlaubte subklassen
// vorteil: vollstaendige switch-ausdruecke ohne default-zweig
public sealed class ShapeSealed permits ShapeSealed.Circle, ShapeSealed.Rectangle, ShapeSealed.Triangle {

    public static final class Circle    extends ShapeSealed { public double radius; public Circle(double r) { radius = r; } }
    public static final class Rectangle extends ShapeSealed { public double w, h;   public Rectangle(double w, double h) { this.w=w; this.h=h; } }
    public static final class Triangle  extends ShapeSealed { public double b, h;   public Triangle(double b, double h) { this.b=b; this.h=h; } }

    // compiler prueft vollstaendigkeit – kein default noetig
    public static double area(ShapeSealed s) {
        return switch (s) {
            case Circle    c -> Math.PI * c.radius * c.radius;
            case Rectangle r -> r.w * r.h;
            case Triangle  t -> (t.b * t.h) / 2;
        };
    }

    public static void main(String[] args) {
        System.out.println(area(new Circle(5)));
        System.out.println(area(new Rectangle(4, 6)));
        System.out.println(area(new Triangle(3, 8)));
    }
}
