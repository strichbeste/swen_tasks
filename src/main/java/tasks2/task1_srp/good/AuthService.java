package tasks2.task1_srp.good;

import java.sql.SQLException;

// nur auth-logik, delegiert an repository und emailservice
public class AuthService {
    private UserRepository userRepo;
    private EmailService emailService;

    public AuthService(UserRepository userRepo, EmailService emailService) {
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    public boolean login(String username, String password) throws SQLException {
        boolean valid = userRepo.exists(username, password);
        if (valid) emailService.sendWelcome(username);
        return valid;
    }

    public void register(String username, String password) throws SQLException {
        userRepo.save(username, password);
    }
}
