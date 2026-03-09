import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// equivalence partitioning + boundary value analysis
// anwendungsfall: altersueberpruefung fuer app (18-99 jahre erlaubt)

// aequivalenzklassen:
// 1. ungueltig: alter < 18 (zu jung)
// 2. gueltig:   18 <= alter <= 99
// 3. ungueltig: alter > 99 (unplausibel)

// grenzwerte: 17, 18, 19 | 98, 99, 100

public class AgeValidatorTest {
    private AgeValidator v = new AgeValidator();

    // --- aequivalenzklasse 1: zu jung ---
    @Test void alter_0_ungueltig()  { assertFalse(v.isValid(0)); }
    @Test void alter_17_ungueltig() { assertFalse(v.isValid(17)); } // grenzwert

    // --- aequivalenzklasse 2: gueltig ---
    @Test void alter_18_gueltig()   { assertTrue(v.isValid(18)); }  // untere grenze
    @Test void alter_19_gueltig()   { assertTrue(v.isValid(19)); }  // knapp drueber
    @Test void alter_50_gueltig()   { assertTrue(v.isValid(50)); }  // mitte
    @Test void alter_99_gueltig()   { assertTrue(v.isValid(99)); }  // obere grenze

    // --- aequivalenzklasse 3: zu alt ---
    @Test void alter_100_ungueltig(){ assertFalse(v.isValid(100)); } // grenzwert
    @Test void alter_150_ungueltig(){ assertFalse(v.isValid(150)); }
}
