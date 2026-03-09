package tasks5.task5_equivalence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// equivalence partitioning + boundary value analysis
// klassen: <18 (ungueltig) | 18-99 (gueltig) | >99 (ungueltig)
// grenzwerte: 17, 18, 19 | 98, 99, 100
public class AgeValidatorTest {
    private final AgeValidator v = new AgeValidator();

    // klasse 1: zu jung
    @Test void alter_0_ungueltig()   { assertFalse(v.isValid(0)); }
    @Test void alter_17_ungueltig()  { assertFalse(v.isValid(17)); } // grenzwert
    // klasse 2: gueltig
    @Test void alter_18_gueltig()    { assertTrue(v.isValid(18)); }  // untere grenze
    @Test void alter_19_gueltig()    { assertTrue(v.isValid(19)); }
    @Test void alter_50_gueltig()    { assertTrue(v.isValid(50)); }
    @Test void alter_99_gueltig()    { assertTrue(v.isValid(99)); }  // obere grenze
    // klasse 3: zu alt
    @Test void alter_100_ungueltig() { assertFalse(v.isValid(100)); } // grenzwert
    @Test void alter_150_ungueltig() { assertFalse(v.isValid(150)); }
}
