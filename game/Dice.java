import java.util.Random;

public class Dice{
    private static Random rand = new Random();

    private int rollDice(int maxDice, int diceAmount){
        int total = 0;
        for(int i = 0; i < diceAmount; i++) {
            int r = rand.nextInt(maxDice) + 1;
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            System.out.println(r);
            total += r;
        }
        try {
            Thread.sleep(500);
         } catch (Exception e) {
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

    public void clash(Enemy enemy, Player player){
        System.out.print(player.getName() + " rolling");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println(" ");    
        int playerRoll = playerRoll(player);

        System.out.print(enemy.getName() + " rolling");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println(" ");    
        int enemyRoll = enemyRoll(enemy);

        if(playerRoll > enemyRoll){
            enemy.setDiceAmount(enemy.getDiceAmount() - 1);
            System.out.println(enemy.getName() + " is staggered! (-1 Dice)");
        } else if (playerRoll < enemyRoll){
            player.setDiceAmount(player.getDiceAmount() - 1);
            System.out.println(player.getName() + "is staggered! (-1 Dice)");
        } else if(playerRoll == enemyRoll){
            System.out.println("Clash!");
        }
        
        Fight fight = new Fight(player, enemy);
        if(player.getDiceAmount() != 0 && enemy.getDiceAmount() != 0){
            fight.battle(player, enemy);
        } else if(player.getDiceAmount() == 0){
            System.out.println(player.getName() + " has died.");
            System.exit(0);
        } else if(enemy.getDiceAmount() == 0){
            System.out.println(player.getName() + " has defeated " + enemy.getName() + "!");
            player.setDiceAmount(3);
        }
    }

}
