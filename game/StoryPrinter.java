public class StoryPrinter {
    
    @SuppressWarnings("BusyWait")
    public static void StoryTyper (String text, int delayMillis) {
        for (char c : text.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
