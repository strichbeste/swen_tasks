package tasks2.task5_isp.good;

// isp eingehalten: nur das interface das benoetigt wird
public class RobotVacuum implements ICleaner {
    @Override public void clean() { System.out.println("saugen..."); }
}
