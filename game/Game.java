import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char op;
        System.out.println("Skip Story? Y/N");
        char skip = sc.next().charAt(0);
        if(Character.toLowerCase(skip) == 'n') {
            StoryPrinter.StoryTyper("In the days before the fall, the world flourished with unyielding light.", 70); 
            StoryPrinter.StoryTyper("The rivers sang with purity, the forests swayed in endless green, and the stars shone to guide us.", 70); 
            StoryPrinter.StoryTyper("And the Celestials still walked among mortals.", 70);
            System.out.println();
            StoryPrinter.StoryTyper("But balance is fragile... and one betrayed us all.", 70);
            System.out.println();
            StoryPrinter.StoryTyper("A Celestial, whose name has been struck from memory, raised his hand against the heavens.", 70);
            StoryPrinter.StoryTyper("With wrath and hunger, he cut down seven of the Major Stars, the very pillars that bound sky and earth together.", 70);
            StoryPrinter.StoryTyper("Their deaths tore wounds across the firmament. And from those wounds, darkness poured.", 70);
            StoryPrinter.StoryTyper("The fractures spread, spilling void across the lands.", 70);
            StoryPrinter.StoryTyper("Cities crumbled, seas boiled, and where once light dwelled, now only shadow and silence remain.", 70);
            System.out.println();
            StoryPrinter.StoryTyper("The Cataclysm had begun.", 200);
            StoryPrinter.StoryTyper("Now... we endure.", 150);
            System.out.println();
            StoryPrinter.StoryTyper("You stand in Mykitiakos, the final bastion of mankind.", 70);
            StoryPrinter.StoryTyper("Walls of stone shield us from the endless night, but the void gnaws at our gates.", 70);
            StoryPrinter.StoryTyper("Each month, by decree of the King, chosen souls are sent into the black. Warriors, prisoners, the desperate.", 70);
            StoryPrinter.StoryTyper("Few return, and those who do are... changed. Eyes hollow, voices trembling, their very essence scarred.", 70);
            System.out.println();
            StoryPrinter.StoryTyper("And now, you are among them.", 150);
            StoryPrinter.StoryTyper("One chosen to tread the void, to face what lurks beyond the broken stars.", 70);
            StoryPrinter.StoryTyper("Remember this well, for what you bring back may decide whether humanity survives another dawn... or sinks into eternal night.", 70);
            System.out.println();
        } else if (Character.toLowerCase(skip) != 'n' && Character.toLowerCase(skip) != 'y'){
            do { 
                System.out.println("Error");
                System.out.print("Skip Story? Y/N");
                skip = sc.next().charAt(0);
            } while (Character.toLowerCase(skip) != 'n' && Character.toLowerCase(skip) != 'y');
        }
        sc.nextLine();

        System.out.println();
        StoryPrinter.StoryTyper(".", 1000);
        StoryPrinter.StoryTyper(".", 1000);
        StoryPrinter.StoryTyper(".", 1000);
        System.out.println();

        StoryPrinter.StoryTyper("Young soldier, what is your name?", 70);
        System.out.print("Enter player name: ");
        String name = sc.nextLine();
        Player player1 = new Player(name);

        String intro = player1.getName() + " huh... ";

        StoryPrinter.StoryTyper(intro, 70);
        StoryPrinter.StoryTyper("/The soldier studies you for a moment, his gaze weary yet steady./", 70);
        StoryPrinter.StoryTyper("Keep your blade sharp and your heart sharper. In the void, its not just monsters youll face but also fear itself.", 70);
        StoryPrinter.StoryTyper("/He turns toward the the gate./", 70);
        StoryPrinter.StoryTyper("Open the gates!!", 70);
        System.out.println();
        StoryPrinter.StoryTyper("/Heavy chains rattle to life, grinding against rusted gears./", 70);
        StoryPrinter.StoryTyper("/The iron gate groans as it rises, each echoing clank swallowed by the silence beyond./", 70);
        StoryPrinter.StoryTyper("/A breathless chill seeps through the widening crack, carrying whispers not meant for mortal ears./", 70);
        StoryPrinter.StoryTyper("/The void stares back. Endless, suffocating, and alive with a presence that hungers./", 80);
        System.out.println();
        StoryPrinter.StoryTyper("/The soldier pats you in the shoulder./", 70);
        StoryPrinter.StoryTyper("Godspeed... May the 3 founders; Myko, Amanita and Chantarelle be on your side.", skip);
        StoryPrinter.StoryTyper("/He walks away, his shoulder heavy./", 70);
        System.out.println();
        StoryPrinter.StoryTyper("You have entered the void...", 200);
        System.out.println();

        do {
            System.out.print("What do you do? ");

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

