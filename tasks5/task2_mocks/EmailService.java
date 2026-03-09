// interface das wir mocken werden
public interface EmailService {
    boolean send(String to, String message);
    int getSentCount();
}
