public class Player{
    private int health;
    private int attack;
    private final String name;
    private final int maxDice;
    private int diceAmount;
    private final int maxDiceAmount;
    private int maxHP;
    private double critChance;

    public Player(String name){
        this.name = name;
        health = 100;
        attack = 10;
        maxDice = 20;
        diceAmount = 3;
        maxDiceAmount = diceAmount;
        maxHP = health;
        critChance = 0.1;
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
            System.out.println(name + " has died. Game Over");
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

    public double getCritChance(){
        return critChance;
    }

    public void setCritChance(double critChance){
        this.critChance = critChance;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
