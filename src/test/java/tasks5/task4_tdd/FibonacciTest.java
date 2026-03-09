package tasks5.task4_tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// tdd: red -> green -> refactor
// zyklus 1: basisfall | zyklus 2: rekursion | zyklus 3: randfaelle
public class FibonacciTest {
    private Fibonacci fib;
    @BeforeEach void setup() { fib = new Fibonacci(); }

    // zyklus 1
    @Test void fib_0_is_0() { assertEquals(0,  fib.calc(0)); }
    @Test void fib_1_is_1() { assertEquals(1,  fib.calc(1)); }
    // zyklus 2
    @Test void fib_5_is_5()  { assertEquals(5,  fib.calc(5)); }
    @Test void fib_10_is_55(){ assertEquals(55, fib.calc(10)); }
    // zyklus 3
    @Test void fib_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> fib.calc(-1));
    }
}
