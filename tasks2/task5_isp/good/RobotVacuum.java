package good;

// isp eingehalten: nur das interface implementieren das benoetigt wird
public class RobotVacuum implements ICleaner {
    @Override
    public void clean() {
        System.out.println("saugen...");
    }
    // kein cook(), kein playMusic() -> kein leerer code
}
