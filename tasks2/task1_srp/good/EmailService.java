package good;

// verantwortung 2: nur email-versand
// wenn email-text oder -provider wechselt, wird nur diese klasse geaendert
public class EmailService {
    public void sendWelcome(String username) {
        System.out.println("willkommens-email gesendet an: " + username);
    }
}
