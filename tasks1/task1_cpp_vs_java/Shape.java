// basisklasse fuer alle formen – entspricht der abstrakten c++ basisklasse
public abstract class Shape {
    protected String color;

    // konstruktor – in c++ wuerde man hier auch initialisierungslisten nutzen
    public Shape(String color) {
        this.color = color;
    }

    // abstrakte methode – in c++ waere das: virtual double area() = 0;
    public abstract double area();

    // virtuelle methode – in c++ braucht man explizit 'virtual'
    // in java sind alle methoden standardmaessig virtuell (dynamic dispatch)
    public String describe() {
        return "form: " + getClass().getSimpleName() + ", farbe: " + color;
    }
}
