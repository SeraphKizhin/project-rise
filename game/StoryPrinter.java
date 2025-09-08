public class StoryPrinter {
    
    public static void StoryTyper (String text, int delayMillis) {
        for (char c : text.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(delayMillis);
            } catch (Exception e) {
            }
        }
        System.out.println();
    }
}