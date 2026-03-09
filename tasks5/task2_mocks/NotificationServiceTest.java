import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

// test mit mock-objekten – emailservice wird gemockt
public class NotificationServiceTest {

    @Test void test_successful_notification() {
        // mock erstellen: emailservice wird simuliert, kein echter email-versand
        EmailService mockEmail = mock(EmailService.class);

        // verhalten definieren: send() gibt true zurueck wenn aufgerufen
        when(mockEmail.send(anyString(), anyString())).thenReturn(true);

        NotificationService service = new NotificationService(mockEmail);
        boolean result = service.notifyUser("test@example.com", "hallo");

        assertTrue(result);
        // verifizieren dass send() genau einmal aufgerufen wurde
        verify(mockEmail, times(1)).send("test@example.com", "hallo");
    }

    @Test void test_empty_email_skips_send() {
        EmailService mockEmail = mock(EmailService.class);
        NotificationService service = new NotificationService(mockEmail);

        boolean result = service.notifyUser("", "hallo");

        assertFalse(result);
        // send() darf bei leerem email NICHT aufgerufen werden
        verify(mockEmail, never()).send(any(), any());
    }
}
