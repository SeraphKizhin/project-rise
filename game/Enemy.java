import java.util.Random;

public class Enemy {
    private final static Random rand = new Random();
    private String name;
    private int maxDice;
    private int diceAmount;

    public Enemy(String name, int maxDice, int diceAmount){
        this.name = name;
        this.maxDice = maxDice;
        this.diceAmount = diceAmount;
    }
    
    public void monsterChoose(){
        int monster = rand.nextInt(2);
        if (monster == 1) {
            this.name = "Bandit";
            this.maxDice = 15;
            this.diceAmount = 3;
        } else {
            this.name = "Goblin";
            this.maxDice = 12;
            this.diceAmount = 2;
        }
    }

    public static Enemy monsterChoose(int n){
        int monster = n;
        if (monster == 1) {
            return new Enemy("Bandit", 15, 3);
        } else {
            return  new Enemy("Goblin", 12, 2);
        }
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
