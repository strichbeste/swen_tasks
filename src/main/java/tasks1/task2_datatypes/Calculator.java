package tasks1.task2_datatypes;

public class Calculator {
    public double add(double a, double b)      { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double modulo(double a, double b)   { return a % b; }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("division durch null");
        return a / b;
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
