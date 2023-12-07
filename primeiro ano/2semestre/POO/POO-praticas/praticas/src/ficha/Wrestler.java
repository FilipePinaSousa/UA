package ficha;

public class Wrestler extends Fighter {
    private int speed;

    public Wrestler(String name) {
        super(name);
        this.speed = (int) (Math.random() * 10) + 1;
    }
    public Wrestler() {
        super();
        this.speed = (int) (Math.random() * 10) + 1;
    }

    // Getter e Setter
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // toString, equals e hashCode
    @Override
    public String toString() {
        return super.toString() + "Speed: " + speed + "\n";
    }
    public Boolean equals(Wrestler wrestler){
        if(super.equals(wrestler) && this.speed == wrestler.speed){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return super.hashCode() + speed * speed;
    }

    // Métodos
    public void attack(Fighter fighter) {
        int dist = (int) (Math.random() * 10) + 1;
        if(dist < this.speed){
            int dmg = (int) (Math.random() * 10) + 1;
            fighter.takeDamage(dmg);
        }
    }

}
