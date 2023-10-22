

public class Dictionary {
    private static final String[] dict = {"hello", "world", "tinkoff", "java", "laptop", "microphone"};

    private static int getRandomNumber() {
        return (int) (Math.random() * 6);
    }

    public static char[] randomWord() {
        return dict[getRandomNumber()].toCharArray();
    }
}
