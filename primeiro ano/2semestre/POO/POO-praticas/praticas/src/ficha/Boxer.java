package ficha;

public class Boxer extends Fighter {
    private int range;

    public Boxer(String name) {
        super(name);
        this.range = (int) (Math.random() * 10) + 1;
    }
    public Boxer() {
        super();
        this.range = (int) (Math.random() * 10) + 1;
    }

    // Getter e Setter
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }

    // toString, equals e hashCode
    @Override
    public String toString() {
        return super.toString() + "Range: " + range + "\n";
    }
    public Boolean equals(Boxer boxer){
        if(super.equals(boxer) && this.range == boxer.range){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return super.hashCode() + range * range;
    }

    // Métodos
    public void attack(Fighter fighter) {
        int dist = (int) (Math.random() * 10) + 1;
        if(dist < this.range){
            int dmg = (int) (Math.random() * 10) + 1;
            fighter.takeDamage(dmg);
        }
    }

}
