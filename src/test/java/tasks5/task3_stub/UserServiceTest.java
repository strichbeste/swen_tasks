package tasks5.task3_stub;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test void test_get_display_name() {
        DatabaseService stub = mock(DatabaseService.class);
        when(stub.getUserById(1)).thenReturn("Brenner");
        when(stub.getUserById(99)).thenReturn(null);

        UserService service = new UserService(stub);
        assertEquals("user: Brenner", service.getDisplayName(1));
        assertEquals("unbekannt",     service.getDisplayName(99));
    }

    @Test void test_register() {
        DatabaseService stub = mock(DatabaseService.class);
        when(stub.saveUser(anyString())).thenReturn(true);

        UserService service = new UserService(stub);
        assertTrue(service.register("Brenner"));
        assertFalse(service.register("ab")); // zu kurz -> db nicht aufgerufen
        verify(stub, never()).saveUser("ab");
    }
}
