import java.util.Arrays;
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

    // calculate payout based on the row and the player's bet
    public int getPayout(Symbol[] row, int bet) {
        // Count how many unique symbols are in the row
        long distinctCount = Arrays.stream(row).distinct().count();

        if (distinctCount == 1) {
            // All 3 symbols match → Triple payout
            Symbol tripleSymbol = row[0];
            int multiplier = tripleSymbol.getTripleMultiplier();
            System.out.println("Triple " + tripleSymbol + "! Multiplier: " + multiplier + "x");
            return bet * multiplier;
        } else if (distinctCount == 2) {
            // Two symbols match → Double payout
            Symbol matching = findMatchingSymbol(row);
            int multiplier = matching.getDoubleMultiplier();
            System.out.println("Two of a kind: " + matching + "! Multiplier: " + multiplier + "x");
            return bet * multiplier;
        }

        // No matches → No payout
        System.out.println("No matches.");
        return 0;
    }

    private Symbol findMatchingSymbol(Symbol[] row) {
        if (row[0] == row[1] || row[0] == row[2]) {
            return row[0];
        } else {
            return row[1];
        }
    }
}
