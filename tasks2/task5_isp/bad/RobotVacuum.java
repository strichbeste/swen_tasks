package bad;

// verletzung: roboterstaubsauger muss cook() und playMusic() implementieren
// obwohl er das nicht kann
public class RobotVacuum implements IHomeAssistant {
    @Override public void clean() { System.out.println("saugen..."); }

    // isp verletzung: leere implementierung oder exception
    @Override public void cook() { throw new UnsupportedOperationException("kann nicht kochen"); }
    @Override public void playMusic() { /* macht nichts */ }
}
