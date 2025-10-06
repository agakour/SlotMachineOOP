import java.util.Random;

public enum Symbol {
    //FIELDS
    // enum constants with associated emojis and payout multipliers
    CHERRY("🍒", 2, 3),
    LEMON("🍋", 3, 4),
    ORANGE("🍊", 4, 5),
    WATERMELON("🍉", 5, 10),
    GRAPES("🍇", 10, 20);

    //fields for emojis and multipliers
    private final String emoji;
    private final int doubleMultiplier;
    private final int tripleMultiplier;

    //CONSTRUCTOR
    // initializes the emoji for each symbol
    Symbol(String emoji, int doubleMultiplier, int tripleMultiplier) {
        this.emoji = emoji;
        this.doubleMultiplier = doubleMultiplier;
        this.tripleMultiplier = tripleMultiplier;
    }

    // METHODS

    //get a random symbol
    public static Symbol getRandomSymbol(Random rnd) {
        Symbol[] values = values();
        return values[rnd.nextInt(values.length)];
    }

    //GETTERS
    public void getEmoji() {
    }

    public int getDoubleMultiplier() {
        return doubleMultiplier;
    }

    public int getTripleMultiplier() {
        return tripleMultiplier;
    }


    // toString method so Symbol prints as its emoji
    @Override
    public String toString() {
        return emoji;
    }
}
