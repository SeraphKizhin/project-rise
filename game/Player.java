public class Player{
    private int health;
    private final int attack;
    private final int shield;
    private final String name;
    private final int maxDice;
    private int diceAmount;

    public Player(String name){
        this.name = name;
        health = 100;
        attack = 10;
        shield = 10;
        maxDice = 20;
        diceAmount = 3;
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

    public int getDice(){
        return maxDice;
    }

    public int getDiceAmount(){
        return diceAmount;
    }

    
    public void setDiceAmount(int diceAmount){
        this.diceAmount = diceAmount;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
