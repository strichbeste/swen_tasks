import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

// test mit stub: datenbank wird durch stub ersetzt
public class UserServiceTest {

    @Test void test_get_display_name_known_user() {
        DatabaseService stub = mock(DatabaseService.class);

        // stub gibt bestimmte werte basierend auf parameter zurueck
        when(stub.getUserById(1)).thenReturn("Brenner");
        when(stub.getUserById(99)).thenReturn(null); // unbekannter user

        UserService service = new UserService(stub);

        assertEquals("user: Brenner", service.getDisplayName(1));
        assertEquals("unbekannt", service.getDisplayName(99));
    }

    @Test void test_register_saves_to_db() {
        DatabaseService stub = mock(DatabaseService.class);
        when(stub.saveUser(anyString())).thenReturn(true);

        UserService service = new UserService(stub);
        assertTrue(service.register("Brenner"));
        assertFalse(service.register("ab")); // zu kurz -> db wird nicht aufgerufen
    }
}
