package tasks2.task4_fat_controller.good;

public class UserValidator {
    public boolean isValid(String username, String password) {
        return username != null && username.length() >= 3
            && password != null && password.length() >= 6;
    }
}
