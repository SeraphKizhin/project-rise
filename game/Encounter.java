import java.util.*;

class WeightedEncounter {
    Runnable action;
    int weight;

    WeightedEncounter(Runnable action, int weight) {
        this.action = action;
        this.weight = weight;
    }
}


public class Encounter {
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);
    private Player player;
    private final List<WeightedEncounter> encounters = new ArrayList<>();
    private final int t = 70;
    
    public Encounter(Player player, Scanner sc){
        this.player = player;
        this.sc = sc;

        //============================
        // Voidlings (minor)
        //============================
        encounters.add(new WeightedEncounter(() -> {
            System.out.println("A faint shiver ripples through the void as a tiny form creeps into view, its hollow eyes fixed on you.");
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
            Scenario.ruptureWeight++;
            Enemy voidlingM = Enemy.monsterChoose(5);
            Fight battle = new Fight(this.player, voidlingM);
            battle.battle(this.player, voidlingM);
        }, 1));

        //============================
        // Kobold
        //============================
        encounters.add(new WeightedEncounter(() -> {
            System.out.println("A kobold scurries towards you.");
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
            Enemy kobold = Enemy.monsterChoose(4);
            Fight battle = new Fight(this.player, kobold);
            battle.battle(this.player, kobold);
        }, 5));

        //============================
        // Bandit
        //============================
        encounters.add(new WeightedEncounter(() -> {
            System.out.println("A bandit pounced on you from the dark.");
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
        }, 5));

        //============================
        // Goblin
        //============================
        encounters.add(new WeightedEncounter(() -> {
            StoryPrinter.StoryTyper("A goblin pounced on you from the dark.", 70);
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
        }, 5));

        // //============================
        // // 
        // //============================
        // scenarios.add(new WeightedScenario(() -> {

        // }, 1));

    }

    public void trigger(){
        int totalWeight = encounters.stream().mapToInt(s -> s.weight).sum();
        int roll = rand.nextInt(totalWeight);

        int cumulative = 0;
        for(WeightedEncounter e : encounters){
            cumulative += e.weight;
            if(roll < cumulative) {
                e.action.run();
                break;
            }
        }
    }
}
