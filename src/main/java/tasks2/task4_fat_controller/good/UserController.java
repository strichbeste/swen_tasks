package tasks2.task4_fat_controller.good;

// schlanker controller: nur koordination, keine eigene logik
public class UserController {
    private UserValidator validator;
    private AuthService authService;

    public UserController(UserValidator validator, AuthService authService) {
        this.validator = validator;
        this.authService = authService;
    }

    public String register(String username, String password) {
        if (!validator.isValid(username, password)) return "validierungsfehler";
        authService.register(username, password);
        return "ok";
    }
}
