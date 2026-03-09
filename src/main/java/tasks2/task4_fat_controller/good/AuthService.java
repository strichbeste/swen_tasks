package tasks2.task4_fat_controller.good;

public class AuthService {
    public void register(String username, String password) {
        String hashed = password + "_hashed";
        System.out.println("user registriert: " + username);
    }
}
