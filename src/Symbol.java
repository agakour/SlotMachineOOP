import java.util.Random;

public enum Symbol {
    CHERRY("🍒"),
    LEMON("🍋"),
    ORANGE("🍊"),
    WATERMELON("🍉"),
    GRAPES("🍇");

    //fields
    private final String emoji;

    //constructor
    Symbol(String emoji) {
        this.emoji = emoji;
    }

    // method to get a random symbol
    public static Symbol getRandomSymbol(Random rnd) {
        Symbol[] values = values();
        return values[rnd.nextInt(values.length)];
    }

    // getters
    public void getEmoji() {
    }

    // toString method so Symbol = emoji
    @Override
    public String toString() {
        return emoji;
    }
}
