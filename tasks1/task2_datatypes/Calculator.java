// einfacher taschenrechner – zeigt methodenerweiterung und typen in der praxis
public class Calculator {

    // addition
    public double add(double a, double b) {
        return a + b;
    }

    // subtraktion
    public double subtract(double a, double b) {
        return a - b;
    }

    // multiplikation
    public double multiply(double a, double b) {
        return a * b;
    }

    // division mit fehlerbehandlung
    public double divide(double a, double b) {
        if (b == 0) {
            // statt undefined behavior wie in c++ – klare exception
            throw new ArithmeticException("division durch null nicht erlaubt");
        }
        return a / b;
    }

    // modulo (rest)
    public double modulo(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.printf("10 + 3 = %.2f%n", calc.add(10, 3));
        System.out.printf("10 - 3 = %.2f%n", calc.subtract(10, 3));
        System.out.printf("10 * 3 = %.2f%n", calc.multiply(10, 3));
        System.out.printf("10 / 3 = %.2f%n", calc.divide(10, 3));
        System.out.printf("10 %% 3 = %.2f%n", calc.modulo(10, 3));
    }
}
