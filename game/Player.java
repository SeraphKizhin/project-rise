public class Player{
    private int health;
    private final int attack;
    private final int shield;
    private final String name;

    public Player(String name){
        this.name = name;
        health = 100;
        attack = 10;
        shield = 10;
    }

    public String getName(){
        return name;
    }

    public int getAttack(){
        return attack;
    }

    public int getShield(){
        return shield;
    }
    
    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
