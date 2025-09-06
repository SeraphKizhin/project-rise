import java.util.Random;

public class Enemy {
    Random rand = new Random();
    private String name;

    public Enemy(String name){
        this.name = name;
    }
    
    public void monsterChoose(){
        int monster = rand.nextInt(2);
        if (monster == 1) {
            this.name = "Bandit";
        } else {
            this.name = "Goblin";
        }
    }

    public static Enemy monsterChoose(int n){
        int monster = n;
        if (monster == 1) {
            return new Enemy("Bandit");
        } else {
            return  new Enemy("Goblin");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}