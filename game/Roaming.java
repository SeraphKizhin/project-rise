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
        int roll = rand.nextInt(10);
        if(roll <= 3){
            StoryPrinter.StoryTyper("As you walk through what seems like a forest you find a stranger asking for rations. What do you do?", 70);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\t\tSeduce\t\tor\t\tDevour\n// ");
            String choice = sc.nextLine();
            if(choice.equals("Seduce")){
                StoryPrinter.StoryTyper("The stranger grunts and lets you pass through.",70);
            } else if (choice.equals("Devour")){
                bandit();
            } 
        } else if (roll <= 8){
            StoryPrinter.StoryTyper("As you thread down a damp area, you hear snickering beyond the dark. What do you do?", 70);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\t\tCheck it out\t\tor\t\tTurn back\n// ");
            String choice = sc.nextLine();
            if(choice.equals("Turn") || choice.equals("Turn back")){
                StoryPrinter.StoryTyper("Nothing is worth the risk.",70);
            } else if (choice.equals("Check") || choice.equals("Check it out")){
                goblin();
            } 
        } else if (roll == 9){
            StoryPrinter.StoryTyper("As the wind gently blows, you find a used campsite. What do you do?", 70);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\t\tSleep\t\tor\t\tTurn back\n// ");
            String choice = sc.nextLine();
            if(choice.equals("Turn") || choice.equals("Turn back")){
                StoryPrinter.StoryTyper("Nothing is worth the risk.",70);
            } else if (choice.equals("Sleep")){
                campSite();
            } 
        }

    }

    @SuppressWarnings("BusyWait")
    public void campSite(){
        StoryPrinter.StoryTyper("Tired, you sleep your worries away.", 70);
        System.out.print("Sleeping");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();

        if(player.getHealth() <= player.getMaxHP() - 51){
            player.setHealth(player.getHealth() + 50);
            StoryPrinter.StoryTyper("You rest and recover 50 HP!", 70);
        } else if(player.getHealth() < player.getMaxHP()){
            player.setHealth(player.getMaxHP());
            StoryPrinter.StoryTyper("You had a great rest and recovered to full HP!", 70);
        } else if(player.getHealth() == player.getMaxHP()){
            player.setMaxHP(player.getMaxHP() + 10);
            player.setHealth(player.getMaxHP());
            StoryPrinter.StoryTyper("You slept like a log, feeling stronger than ever! Max HP is increased to 10.", 70);
        }        
    }

    @SuppressWarnings("BusyWait")
    public void goblin(){
        StoryPrinter.StoryTyper("You pounced on the snickering voice.", 70);
        System.out.print("Engaging combat");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();        
        Enemy goblin = Enemy.monsterChoose(0);
        Fight battle = new Fight(this.player, goblin);
        battle.battle(this.player, goblin);
    }

    @SuppressWarnings("BusyWait")
    public void bandit(){
        StoryPrinter.StoryTyper("The angered stranger pounces on you!", 70);
        System.out.print("Engaging combat");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();        
        Enemy bandit = Enemy.monsterChoose(1);
        Fight battle = new Fight(this.player, bandit);
        battle.battle(this.player, bandit);
    }

    @SuppressWarnings("BusyWait")
    public void fight(){
        int roll = rand.nextInt(2);
        if(roll == 0){
            StoryPrinter.StoryTyper("A bandit pounced on you!", 70);
            System.out.print("Engaging combat");
            for(int i = 0; i < 3; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.print(".");
            }
            System.out.println();        
            Enemy bandit = Enemy.monsterChoose(1);
            Fight battle = new Fight(this.player, bandit);
            battle.battle(this.player, bandit);
        } else if(roll == 1){
            StoryPrinter.StoryTyper("A goblin pounced on you!", 70);
            System.out.print("Engaging combat");
            for(int i = 0; i < 3; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.print(".");
            }
            System.out.println();        
            Enemy goblin = Enemy.monsterChoose(0);
            Fight battle = new Fight(this.player, goblin);
            battle.battle(this.player, goblin);
        }
        
    }
}
