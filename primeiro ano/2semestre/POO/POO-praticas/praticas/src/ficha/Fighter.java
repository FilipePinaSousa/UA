package ficha;

public abstract class Fighter {
    
    private String name;
    private int health;
    private int wins;
    private int defeats;

    // Construtores
    public Fighter(String name) {
        this.name = name;
        this.health = 100;
        this.wins = 0;
        this.defeats = 0;
    }
    public Fighter(){
        this.name = "Jhon Doe";
        this.health = 100;
        this.wins = 0;
        this.defeats = 0;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getDefeats() {
        return defeats;
    }
    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    // toString, equals e hashCode
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Health: " + health + "\n" +
                "Wins: " + wins + "\n" +
                "Defeats: " + defeats + "\n";
    }
    public Boolean equals(Fighter fighter){
        if(this.name == fighter.name){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = Double.doubleToLongBits(health+defeats+wins);
        long result = prime * temp + (int) (temp ^ (temp >>> 32));
        return (int) result;
    }

    // Métodos
    public boolean isAlive(Fighter fighter){
        if(fighter.health > 0){
            return true;
        }
        return false;
    }
    public boolean isAlive(){
        if(this.health > 0){
            return true;
        }
        return false;
    }

    public void win(){
        this.wins++;
    }
    public void lose(){
        this.defeats++;
    }

    public abstract void attack(Fighter fighter);

    // Função para facilitar a redução de vida dos figthers
    public void takeDamage(int damage){
        this.health -= damage;
    }

}
