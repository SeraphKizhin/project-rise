import java.util.*;

public class Dice{
    private final static Random rand = new Random();

    @SuppressWarnings("BusyWait")
    private int rollDice(int maxDice, int diceAmount){
        int total = 0;
        for(int i = 0; i < diceAmount; i++) {
            int r = rand.nextInt(maxDice) + 1;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(r + " ");
            total += r;
        }

        System.out.println();

        try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
         }
        System.out.println(total + "!!");

        return total;
    }

    public int playerRoll(Player player){
        return rollDice(player.getDice(), player.getDiceAmount());
    }

    public int enemyRoll(Enemy enemy){
        return rollDice(enemy.getDice(), enemy.getDiceAmount());
    }

}
