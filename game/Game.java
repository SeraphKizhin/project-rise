public class Game {
    public static void main(String[] args) {
        Player Seraph = new Player("Seraph");
        Dice player1 = new Dice(Seraph);

        player1.roll(3);

        Player Kizhin = new Player("Kizhin");
        Dice player2 = new Dice(Kizhin);

        player2.roll(2);
    
    }
}