import java.util.Random;

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

    @SuppressWarnings("BusyWait")
    public void clash(Enemy enemy, Player player){
        System.out.print(player.getName() + " rolling");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();    
        int playerRoll = playerRoll(player);

        System.out.print(enemy.getName() + " rolling");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println(" ");    
        int enemyRoll = enemyRoll(enemy);

        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        if(playerRoll > enemyRoll){
            enemy.setDiceAmount(enemy.getDiceAmount() - 1);
            System.out.println(enemy.getName() + " is staggered! (-1 Dice)");
        } else if (playerRoll < enemyRoll){
            player.setDiceAmount(player.getDiceAmount() - 1);
            System.out.println(player.getName() + " is staggered! (-1 Dice)");
        } else if(playerRoll == enemyRoll){
            System.out.println("Clash!");
        }
        
        Fight fight = new Fight(player, enemy);
        if(player.getDiceAmount() != 0 && enemy.getDiceAmount() != 0){
            clash(enemy, player);
        } else if(player.getDiceAmount() == 0){
            player.takeDamage(enemy.getAtk());
            player.resetDice();
            enemy.resetDice();
            fight.battle(player, enemy);
        } else if(enemy.getDiceAmount() == 0){
            if(player.getDiceAmount() >= 3){
                enemy.takeDamage(player.getAttack() * 2);
            } else {
                enemy.takeDamage(player.getAttack());
                player.resetDice();
            }
            enemy.resetDice();
            if(enemy.getHealth() != 0) fight.battle(player, enemy);
        }
    }

}
