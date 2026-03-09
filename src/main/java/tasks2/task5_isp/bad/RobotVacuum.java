package tasks2.task5_isp.bad;

// muss cook() und playMusic() implementieren obwohl nicht benoetigt
public class RobotVacuum implements IHomeAssistant {
    @Override public void clean()     { System.out.println("saugen..."); }
    @Override public void cook()      { throw new UnsupportedOperationException("kann nicht kochen"); }
    @Override public void playMusic() { /* leer */ }
}
