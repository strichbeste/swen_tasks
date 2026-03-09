package tasks5.task2_mocks;

public interface EmailService {
    boolean send(String to, String message);
    int getSentCount();
}
