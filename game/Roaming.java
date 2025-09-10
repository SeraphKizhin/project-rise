import java.util.*;

public class Roaming {
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    private Scenario scenario;
    private Encounter encounter;

    public Roaming(Player player){
        this.scenario = new Scenario(player, sc);
        this.encounter = new Encounter(player, sc);
    }

    public void roam(){
        int roll = rand.nextInt(2);
        if(roll == 0){
            scenario.trigger();
        } else {
            encounter.trigger();
        }
    }
}
