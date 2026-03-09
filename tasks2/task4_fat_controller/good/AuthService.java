package good;

// nur auth-logik
public class AuthService {
    public void register(String username, String password) {
        String hashed = password + "_hashed"; // passwort-hashing
        System.out.println("user registriert: " + username);
        // hier wuerde repo.save() und emailService.send() aufgerufen
    }
}
