import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// 5 sinnvolle testfaelle fuer die fakultaet-funktion
public class FactorialTest {
    private Factorial f = new Factorial();

    // randfall: 0! = 1 per definition
    @Test void test_zero() {
        assertEquals(1L, f.calculate(0));
    }

    // randfall: 1! = 1
    @Test void test_one() {
        assertEquals(1L, f.calculate(1));
    }

    // normalfall
    @Test void test_five() {
        assertEquals(120L, f.calculate(5));
    }

    // groesserer wert
    @Test void test_ten() {
        assertEquals(3628800L, f.calculate(10));
    }

    // fehlerfall: negative zahl soll exception werfen
    @Test void test_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> f.calculate(-1));
    }
}
