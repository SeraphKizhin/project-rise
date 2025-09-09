import java.util.Random;

public class Enemy {
    private final static Random rand = new Random();
    private String name;
    private int maxDice;
    private final int maxDiceAmount;
    private int diceAmount;
    private int health;
    private int atk;

    public Enemy(String name, int maxDice, int diceAmount, int health, int atk){
        this.name = name;
        this.maxDice = maxDice;
        this.diceAmount = diceAmount;
        this.health = health;
        this.atk = atk;
        maxDiceAmount = diceAmount;
    }
    
    public void monsterChoose(){
        int monster = rand.nextInt(2);
        if (monster == 1) {
            this.name = "Bandit";
            this.maxDice = 15;
            this.diceAmount = 3;
            this.health = 100;
            this.atk = 10;
        } else {
            this.name = "Goblin";
            this.maxDice = 12;
            this.diceAmount = 2;
            this.health = 50;
            this.atk = 10;
        }
    }

    public static Enemy monsterChoose(int n){
        int monster = n;
        if (monster == 1) {
            return new Enemy("Bandit", 15, 3, 100, 10);
        } else {
            return  new Enemy("Goblin", 12, 2, 50, 10);
        }
    }

    public void takeDamage(int n){
        this.health = health - n;
        if(health <= 0){
            System.out.println(name + " has died.");
        } else {
            System.out.println(name + " took " + n + " damage. " + health + " left!");
        }
    }

    public void resetDice(){
        this.diceAmount = maxDiceAmount;
    }

    public int getHealth(){
        return health;
    }

    public int getAtk(){
        return  atk;
    }

    public String getName(){
        return name;
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

    @Override
    public String toString() {
        return this.name;
    }
}
