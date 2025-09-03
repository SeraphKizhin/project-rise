public class Dice{
    private final int min;
    private final int max;
    private Player player;

    public Dice(Player player){
        this.player = player;
        min = 1;
        max = 21;
    }

    public void roll(int n){
        for(int i = 0; i < n; i++){
            int randomInt = min + (int)(Math.random() * ((max - min) + 1));
            System.out.println(player.getName() + ": " + randomInt);
        }
    }
}