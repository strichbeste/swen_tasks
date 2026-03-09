package tasks5.task2_mocks;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test void test_successful_notification() {
        EmailService mockEmail = mock(EmailService.class);
        when(mockEmail.send(anyString(), anyString())).thenReturn(true);

        NotificationService service = new NotificationService(mockEmail);
        assertTrue(service.notifyUser("test@example.com", "hallo"));
        verify(mockEmail, times(1)).send("test@example.com", "hallo");
    }

    @Test void test_empty_email_skips_send() {
        EmailService mockEmail = mock(EmailService.class);
        NotificationService service = new NotificationService(mockEmail);
        assertFalse(service.notifyUser("", "hallo"));
        verify(mockEmail, never()).send(any(), any());
    }
}
