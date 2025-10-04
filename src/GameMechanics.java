import java.util.Random;

public class GameMechanics {
    //FIELDS
    private final Random random; // random generator for picking symbols

    //CONSTRUCTOR
    //initializes random generator
    public GameMechanics() {
        this.random = new Random();
    }

    // METHODS

    // spin a row of 3 random symbols
    public Symbol[] spinRow() {
        Symbol[] row = new Symbol[3];
        for (int i = 0; i < row.length; i++) {
            row[i] = Symbol.getRandomSymbol(random);
        }
        return row;
    }

    // prints the row in a formatted way
    public void printRow(Symbol[] row) {
        System.out.println("**************");
        System.out.println(" " + row[0] + " | " + row[1] + " | " + row[2]);
        System.out.println("**************");
    }

    // calculate payout based on the row and the bet
    public int getPayout(Symbol[] row, int bet) {
        //  case 1: all three match
        if (row[0] == row[1] && row[1] == row[2]) {
            return switch (row[0]) {
                case CHERRY -> bet * 3;
                case LEMON -> bet * 4;
                case ORANGE -> bet * 5;
                case WATERMELON -> bet * 10;
                case GRAPES -> bet * 20;
            };
        }
        // first two match
        else if (row[0] == row[1]) {
            return bet * 2;
        }
        // last two match
        else if (row[1] == row[2]) {
            return bet * 2;
        }
        // no matches
        return 0;
    }
}
