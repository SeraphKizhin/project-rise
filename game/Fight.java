import java.util.Random;

public class Fight {
    Random rand = new Random();
    private final Player player;
    private final Enemy name;

    public Fight(Player player, Enemy name){
        this.player = player;
        this.name = name;
    }

    public void battle(Player player, Enemy name){
        int playerRoll;
        int monsterRoll;
        System.out.println(player + " rolling... ");
        playerRoll = calculation();
        System.out.println(playerRoll);
        System.out.println(name + " rolling... ");
        monsterRoll = calculation();
        System.out.println(monsterRoll);
        if(playerRoll > monsterRoll){
            System.out.println("Player wins!");
        } else if (monsterRoll > playerRoll) {
            System.out.println("Player loses...");
        } else if (playerRoll == monsterRoll) {
            System.out.println("Clash!");
            battle(player, name);
        }
    }

    public int calculation(){
        int rolls = rand.nextInt(21) + 1;
        return rolls;
    }
    
}