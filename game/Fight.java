import java.util.Random;

public class Fight {
    Random rand = new Random();
    private final Player player;
    private final Enemy name;
    private Dice dice;

    public Fight(Player player, Enemy name){
        this.player = player;
        this.name = name;
        this.dice = new Dice();
    }

    public void battle(Player player, Enemy name){
        dice.clash(name, player);
    }
}
