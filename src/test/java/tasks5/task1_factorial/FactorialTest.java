package tasks5.task1_factorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    private final Factorial f = new Factorial();

    @Test void test_zero()             { assertEquals(1L,       f.calculate(0)); }
    @Test void test_one()              { assertEquals(1L,       f.calculate(1)); }
    @Test void test_five()             { assertEquals(120L,     f.calculate(5)); }
    @Test void test_ten()              { assertEquals(3628800L, f.calculate(10)); }
    @Test void test_negative_throws()  { assertThrows(IllegalArgumentException.class, () -> f.calculate(-1)); }
}
