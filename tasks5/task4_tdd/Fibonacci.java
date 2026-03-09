// implementierung NACH den tests (tdd)
public class Fibonacci {
    public long calc(int n) {
        if (n < 0) throw new IllegalArgumentException("kein negativer input");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calc(n - 1) + calc(n - 2);
    }
}
