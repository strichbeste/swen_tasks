// kreis erbt von shape – in c++: class Circle : public Shape
public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        // super() ruft den elternkonstruktor auf – in c++ wuerde man Shape(color) in der initialisierungsliste aufrufen
        super(color);
        this.radius = radius;
    }

    // @Override markiert methodenueberschreibung – compilerfehler falls methode nicht existiert
    // in c++ gibt es 'override' keyword seit c++11, aber kein pflichtzeichen
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
