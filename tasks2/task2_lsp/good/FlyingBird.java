package good;

// zwischenschicht: nur voegel die fliegen koennen erben dies
public abstract class FlyingBird extends Bird {
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " fliegt");
    }

    @Override
    public void move() { fly(); }
}
