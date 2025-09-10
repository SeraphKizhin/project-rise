import java.util.*;

class WeightedScenario {
    Runnable action;
    int weight;

    WeightedScenario(Runnable action, int weight) {
        this.action = action;
        this.weight = weight;
    }
}


public class Scenario {
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);
    private Player player;
    private final List<WeightedScenario> scenarios = new ArrayList<>();
    private final int t = 70;
    private int manifestationCount;
    public static int ruptureWeight = 1;
    String[] emotions = {"fear", "agony", "grief", "anguish"};
    
    public Scenario(Player player, Scanner sc){
        this.player = player;
        this.sc = sc;
        manifestationCount = 0;

        //============================
        // Voidling (minor)
        //============================
        ScenarioNode ruptureNode = new ScenarioNode(
            "As you walk ahead, a sudden wave of dread washes over you. Your head throbs, your steps falter, and through the haze, you see a Rupture. A jagged crack in the very fabric of space, from which the void oozes, whispering a cold, unnatural emptiness."
        );
        ruptureNode.addChoice("Stand Your Ground",() -> {
            StoryPrinter.StoryTyper("You pick yourself up and stand your ground.", t);
            Enemy voidling = Enemy.monsterChoose(5);
            Fight battle = new Fight(player, voidling);
            battle.battle(player, voidling);
            ruptureWeight = 1;
        });
        ruptureNode.addChoice("Withdraw",() -> {
            StoryPrinter.StoryTyper("You withdraw from the rupture.", t);
            if(ruptureWeight > 1){
                ruptureWeight-=2;
            } else {
                ruptureWeight = 1;
            }
        });
        scenarios.add(new WeightedScenario(() -> ruptureNode.play(sc), ruptureWeight));

        //============================
        // Kobold
        //============================
        ScenarioNode koboldNode = new ScenarioNode(
            "As you tread through a narrow cave, you notice a small scuttling figure darting between the rocks. What do you do?"
        );
        koboldNode.addChoice("Fight",() -> {
            StoryPrinter.StoryTyper("You chased after the figure.", t);
            Enemy kobold = Enemy.monsterChoose(4);
            Fight battle = new Fight(player, kobold);
            battle.battle(player, kobold);
        });
        koboldNode.addChoice("Sneak",() -> {
            StoryPrinter.StoryTyper("You sneaked passed the figure.", t);
        });
        koboldNode.addChoice("Intimidate",() -> {
            StoryPrinter.StoryTyper("You made some noise by hitting the walls with your weapon. The figure hurrily scurried away.", t);
        });
        scenarios.add(new WeightedScenario(() -> koboldNode.play(sc), 4));

        //============================
        // Manifestation
        //============================
        String emotion = emotions[rand.nextInt(emotions.length)];
        ScenarioNode manifestationNode = new ScenarioNode(
            "Your " + emotion + " gnaws at you..."
        );
        manifestationNode.addChoice("Face it",() ->{
            StoryPrinter.StoryTyper("You steeled yourself and face your " + emotion +".", t);
            Enemy manifestation = Enemy.monsterChoose(3);
            Fight battle = new Fight(player, manifestation);
            battle.battle(player, manifestation);
        });
        manifestationNode.addChoice("Flee",() ->{
            manifestationCount++;
            if(manifestationCount >=5){
                StoryPrinter.StoryTyper("Your " + emotion + " overwhelms you.", t);
                Enemy manifestation = Enemy.monsterChoose(3);
                Fight battle = new Fight(player, manifestation);
                battle.battle(player, manifestation);
                manifestationCount = 0;
            } else {
                StoryPrinter.StoryTyper("You flee from your " + emotion + ". But you know you can't run forever.", t);
                player.setHealth(player.getHealth() - 10);
            }
        });
        int baseWeight = 1;
        int hpFactor = (player.getMaxHP() - player.getHealth()) / 10;
        scenarios.add(new WeightedScenario(() -> manifestationNode.play(sc),  baseWeight + hpFactor));


        //============================
        // Bandit
        //============================
        ScenarioNode banditNode = new ScenarioNode(
            "As you walk through what seems like a forest you find a stranger asking for rations. What do you do?"
        );
        banditNode.addChoice("Seduce", () -> {
            StoryPrinter.StoryTyper("The stranger grunts and lets you pass through.",t);
        });
        banditNode.addChoice("Devour", () -> {
            StoryPrinter.StoryTyper("The angered stranger pounces on you!", t);
            Enemy bandit = Enemy.monsterChoose(1);
            Fight battle = new Fight(this.player, bandit);
            battle.battle(this.player, bandit);
        });
        scenarios.add(new WeightedScenario(() -> banditNode.play(sc), 4));

        //============================
        // Goblin
        //============================
        ScenarioNode goblinNode = new ScenarioNode(
            "As you thread down a damp area, you hear snickering beyond the dark. What do you do?"
        );
        goblinNode.addChoice("Check it out",() -> {
            StoryPrinter.StoryTyper("You pounced on the snickering voice.", t);
            Enemy goblin = Enemy.monsterChoose(0);
            Fight battle = new Fight(this.player, goblin);
            battle.battle(this.player, goblin);
        });
        goblinNode.addChoice("Turn back",() -> {
            StoryPrinter.StoryTyper("Nothing is worth the risk.", t);
        });
        scenarios.add(new WeightedScenario(() -> goblinNode.play(sc), 4));

        //============================
        // Camp
        //============================
        ScenarioNode campNode = new ScenarioNode(
            "As the wind gently blows, you find a used campsite. What do you do?"
        );
        campNode.addChoice("Set up camp",() -> {
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
        });
        campNode.addChoice("Leave",() -> {
            StoryPrinter.StoryTyper("Nothing is worth the risk.", t);
        });
        scenarios.add(new WeightedScenario(() -> campNode.play(sc), 1));

        // //============================
        // // 
        // //============================
        // scenarios.add(new WeightedScenario(() -> {}, 1));

    }

    public void trigger(){
        int totalWeight = scenarios.stream().mapToInt(s -> s.weight).sum();
        int roll = rand.nextInt(totalWeight);

        int cumulative = 0;
        for(WeightedScenario s : scenarios){
            cumulative += s.weight;
            if(roll < cumulative) {
                s.action.run();
                break;
            }
        }
    }
}

/*
 * Roaming decides whether to call scenario or encounter.
 * Rolls 0 or 1
 * then calls Scenario or Encounter
 * 
 * Scenario contains all scenario
 * rolls then decide what encounter
 * 
 * Encounter contains all encounter
 * rolls then decide what encounter
 */