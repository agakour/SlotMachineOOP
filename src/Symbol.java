import java.util.Random;

/**
 * Slot machine symbols with associated emojis and payout multipliers.
 */
public enum Symbol {
    CHERRY("🍒", 2, 3),
    LEMON("🍋", 3, 4),
    ORANGE("🍊", 4, 5),
    WATERMELON("🍉", 5, 10),
    GRAPES("🍇", 10, 20);

    private final String emoji;
    private final int doubleMultiplier;
    private final int tripleMultiplier;

    Symbol(String emoji, int doubleMultiplier, int tripleMultiplier) {
        this.emoji = emoji;
        this.doubleMultiplier = doubleMultiplier;
        this.tripleMultiplier = tripleMultiplier;
    }

    /** Returns a random symbol from the available values. */
    public static Symbol getRandomSymbol(Random rnd) {
        Symbol[] values = values();
        return values[rnd.nextInt(values.length)];
    }

    public String getEmoji() {
        return emoji;
    }

    public int getDoubleMultiplier() {
        return doubleMultiplier;
    }

    public int getTripleMultiplier() {
        return tripleMultiplier;
    }

    @Override
    public String toString() {
        return emoji;
    }
}
