package good;

// schlanker controller: nur koordination, keine logik
// jede verantwortung in eigener klasse (auch srp!)
public class UserController {
    private UserValidator validator;
    private AuthService authService;

    public UserController(UserValidator validator, AuthService authService) {
        this.validator = validator;
        this.authService = authService;
    }

    public String register(String username, String password) {
        // controller delegiert nur
        if (!validator.isValid(username, password)) return "validierungsfehler";
        authService.register(username, password);
        return "ok";
    }
}
