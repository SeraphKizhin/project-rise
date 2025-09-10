import java.util.*;

public class EncounterNode {
    private final String description;
    private final List<Runnable> actions = new ArrayList<>();
    private final List<String> labels = new ArrayList<>();
    private final int t = 70;

    public EncounterNode(String description){
        this.description = description;
    }

    public void addChoice(String label, Runnable action){
        labels.add(label);
        actions.add(action);
    }

    public void play(Scanner sc){
        StoryPrinter.StoryTyper(description, t);

        for(int i = 0; i < labels.size(); i++){
            System.out.println("[" + i +"]" + labels.get(i));
        }
        System.out.print("// ");
        String input = sc.nextLine();

        try {
            int choice = Integer.parseInt(input);
            if(choice >= 0 && choice < actions.size()) {
                actions.get(choice).run();
            } else {
                System.out.println("You stare blankly in the sky... (Invalid Choice)");
            }
        } catch (NumberFormatException e){
            System.out.println("You think too deeply as the void beckons you.. (Enter a number!)");
        }
    }
}