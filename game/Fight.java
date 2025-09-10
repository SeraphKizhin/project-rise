import java.util.*;

public class Fight {
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    private final Dice dice;

    public Fight(Player player, Enemy name){
        this.dice = new Dice();
    }

    public void battle(Player player, Enemy name){
        System.out.println();
        System.out.print("[0]Fight \t\t\t[1]Run\n[2]Item \t\t\t[3]Talk\n// ");
        int action = sc.nextInt();
        System.out.println();
        switch (action) {
            case 0 -> clash(name, player);
            case 1 -> {
                int run = rand.nextInt(2);
                if(run == 1){
                    System.out.println("You successfully escaped.");
                } else {
                    System.out.println("You failed to escape.");
                    player.takeDamage(name.getAtk());
                    this.battle(player, name);
                }
            }
            default -> {
                System.out.println("You don't know what that does...");
                this.battle(player, name);
            }
        }
    }

    @SuppressWarnings("BusyWait")
    public void clash(Enemy enemy, Player player){
        while(player.getDiceAmount() != 0 && enemy.getDiceAmount() != 0){
            // Player Roll
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
            int playerRoll = dice.playerRoll(player);

            // Enemy Roll
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
            int enemyRoll = dice.enemyRoll(enemy);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

            // Dice Compare
             if(playerRoll > enemyRoll){
                 enemy.setDiceAmount(enemy.getDiceAmount() - 1);
                 System.out.println(enemy.getName() + " is staggered! (-1 Dice)");
             } else if (playerRoll < enemyRoll){
                 player.setDiceAmount(player.getDiceAmount() - 1);
                 System.out.println(player.getName() + " is staggered! (-1 Dice)");
             } else if(playerRoll == enemyRoll){
                 System.out.println("Clash!");
             }    
        }
        
        // Damage and Death
        if (player.getDiceAmount() == 0){
            player.takeDamage(enemy.getAtk());
            player.resetDice();
            enemy.resetDice();
            this.battle(player, enemy);
        }

        if(enemy.getDiceAmount() == 0){
            int damage = player.getAttack();

            if(player.getDiceAmount() >= 3){
                damage *= 2;
                System.out.println("You overwhelmed the enemy!");
            } 
            if(rand.nextDouble() < player.getCritChance()) {
                damage *= 2;
                System.out.println("You hit the " + enemy.getName() +"'s vital organs!");
            }

            enemy.takeDamage(damage);

            player.resetDice();
            enemy.resetDice();
            if(enemy.isAlive()) this.battle(player, enemy);
        }
    }
}
