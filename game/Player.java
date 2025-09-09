public class Player{
    private int health;
    private final int attack;
    private final String name;
    private final int maxDice;
    private int diceAmount;
    private final int maxDiceAmount;
    private int maxHP;

    public Player(String name){
        this.name = name;
        health = 100;
        attack = 10;
        maxDice = 20;
        diceAmount = 3;
        maxDiceAmount = diceAmount;
        maxHP = health;
    }

    public String getName(){
        return name;
    }

    public int getAttack(){
        return attack;
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

    public void takeDamage(int n){
        this.health = health - n;
        if(health == 0){
            System.out.println(name + "has died. Game Over");
            System.exit(0);
        }
        System.out.println(name + " took " + n + " damage. " + health + " left!");

    }

    public void resetDice(){
        this.diceAmount = maxDiceAmount;
    }

    public void setMaxHP(int maxHP){
        this.maxHP = maxHP;
    }

    public int getMaxHP(){
        return maxHP;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
