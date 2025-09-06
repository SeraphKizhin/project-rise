import java.util.Random;
import java.util.Scanner;

public class Roaming {
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    private final Player player;

    public Roaming(Player player){
        this.player = player;
    }

    public void roam(){
        int roll = rand.nextInt(2);
        if(roll == 0){
            scenario();
        } else {
            fight();
        }
    }

    public void scenario(){
        System.out.println("As you walk through the forest you find a gentleman asking for chump change. What do you do?\n\tSeduce\tor\tDevour");
        String choice = sc.nextLine();
        if(choice.equals("Seduce")){
            System.out.println("The gentlSeman grunts and lets you pass through.");
        } else if (choice.equals("Devour")){
            fight();
        } 
    }

    public void fight(){
        System.out.println("You pounced on a bandit!\nEntering combat...");
        Enemy bandit = Enemy.monsterChoose(1);
        Fight battle = new Fight(this.player, bandit);
        battle.battle(this.player, bandit);
    }
}