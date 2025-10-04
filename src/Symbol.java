import java.util.Random;

public enum Symbol {
    //FIELDS
    // enum constants with associated emojis
    CHERRY("🍒"),
    LEMON("🍋"),
    ORANGE("🍊"),
    WATERMELON("🍉"),
    GRAPES("🍇");

    // instance field
    private final String emoji;

    //CONSTRUCTOR
    // initializes the emoji for each symbol
    Symbol(String emoji) {
        this.emoji = emoji;
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


    // toString method so Symbol prints as its emoji
    @Override
    public String toString() {
        return emoji;
    }
}
