package tasks5.task2_mocks;

public class NotificationService {
    private EmailService emailService;
    public NotificationService(EmailService e) { this.emailService = e; }

    public boolean notifyUser(String email, String message) {
        if (email == null || email.isBlank()) return false;
        return emailService.send(email, message);
    }
}
