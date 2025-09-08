import java.util.Random;
import java.util.Scanner;

public class Fight {
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    private final Player player;
    private final Enemy name;
    private Dice dice;

    public Fight(Player player, Enemy name){
        this.player = player;
        this.name = name;
        this.dice = new Dice();
    }

    public void battle(Player player, Enemy name){
        Fight fight = new Fight(player, name);
        System.out.print("Fight \t\t\t Run\nItem \t\t\t Talk\n// ");
        String action = sc.nextLine();
        action = action.toLowerCase();
        if(action.equals("fight")){
            dice.clash(name, player);
        } else if (action.equals("run")){
            int run = rand.nextInt(2);
            if(run == 1){
                System.out.println("You successfully escaped.");
            } else {
                System.out.println("You failed to escape.");
                // take damage here
                fight.battle(player, name);
            }
        } else {
            System.out.println("Unknown command.");
            fight.battle(player, name);
        }
    }
}
