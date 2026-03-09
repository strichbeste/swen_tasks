package good;

// smart home kann alles
public class SmartHome implements ICleaner, ICook, IMusicPlayer {
    @Override public void clean() { System.out.println("smart home saugt"); }
    @Override public void cook() { System.out.println("smart home kocht"); }
    @Override public void playMusic() { System.out.println("smart home spielt musik"); }
}
