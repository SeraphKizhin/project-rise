import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char op;

        System.out.print("Enter player name: ");
        String name = sc.nextLine();
        Player player1 = new Player(name);
        Dice playerDice1 = new Dice(player1);

        do {
            System.out.print("Op: ");

            op = sc.next().charAt(0);

            switch (op) {
                case 'r':
                    System.out.println("Rolling...");
                    playerDice1.roll(3);
                    break;
                case 'f':
                    Roaming roaming = new Roaming(player1);
                    System.out.println("Roaming...");
                    roaming.roam();
                    break;
                case 'q':
                    System.out.println("Returning to village...");
                    break;
                default:
                    System.out.println("Unknown Operation");
            }
        } while (op != 'q');
        

        // Player Seraph = new Player("Seraph");
        // Dice player1 = new Dice(Seraph);

        // player1.roll(3);

        // Player Kizhin = new Player("Kizhin");
        // Dice player2 = new Dice(Kizhin);

        // player2.roll(2);
    
    }
}
