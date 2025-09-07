import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char op;

        System.out.print("Enter player name: ");
        String name = sc.nextLine();
        Player player1 = new Player(name);

        do {
            System.out.print("Op: ");

            op = sc.next().charAt(0);

            switch (op) {
                case 'f':
                    Roaming roaming = new Roaming(player1);
                    System.out.print("Roaming");
                    for(int i = 0; i < 3; i++){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.print(".");
                    }
                    System.out.println();
                    roaming.roam();
                    break;
                case 'q':
                    System.out.print("Returning to village");
                    for(int i = 0; i < 3; i++){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.print(".");
                    }
                    break;
                default:
                    System.out.println("Unknown Operation");
            }
        } while (op != 'q');
        
        sc.close();
    }
}

