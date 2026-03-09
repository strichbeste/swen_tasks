package good;

import java.sql.SQLException;

// verantwortung 3: nur authentifizierungslogik
// koordiniert repository und emailservice, aber kein direkter db-code oder email-code
public class AuthService {
    private UserRepository userRepo;
    private EmailService emailService;

    // dependency injection: abhaengigkeiten werden reingegeben, nicht selbst erstellt
    public AuthService(UserRepository userRepo, EmailService emailService) {
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    public boolean login(String username, String password) throws SQLException {
        boolean valid = userRepo.exists(username, password);
        if (valid) {
            emailService.sendWelcome(username);
        }
        return valid;
    }

    public void register(String username, String password) throws SQLException {
        userRepo.save(username, password);
    }
}
