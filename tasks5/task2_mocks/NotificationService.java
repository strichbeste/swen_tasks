// service der emailservice benutzt – wird mit mock getestet
public class NotificationService {
    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean notifyUser(String email, String message) {
        if (email == null || email.isBlank()) return false;
        return emailService.send(email, message);
    }
}
