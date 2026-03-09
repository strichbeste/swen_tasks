package tasks5.task1_factorial;

public class Factorial {
    public long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("negativ nicht erlaubt: " + n);
        if (n <= 1) return 1;
        return n * calculate(n - 1);
    }
}
