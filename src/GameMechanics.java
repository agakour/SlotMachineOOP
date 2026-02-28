import java.util.Arrays;
import java.util.Random;

/**
 * Handles slot spinning and payout calculation.
 */
public class GameMechanics {
    private final Random random;

    public GameMechanics() {
        this.random = new Random();
    }

    /** Spins a row of 3 random symbols. */
    public Symbol[] spinRow() {
        Symbol[] row = new Symbol[3];
        for (int i = 0; i < row.length; i++) {
            row[i] = Symbol.getRandomSymbol(random);
        }
        return row;
    }

    /** Prints the row in a formatted slot-machine style. */
    public void printRow(Symbol[] row) {
        System.out.println("**************");
        System.out.println(" " + row[0] + " | " + row[1] + " | " + row[2]);
        System.out.println("**************");
    }

    /**
     * Calculates the payout based on matching symbols and the player's bet.
     * @return the payout amount (0 if no match)
     */
    public int getPayout(Symbol[] row, int bet) {
        long distinctCount = Arrays.stream(row).distinct().count();

        if (distinctCount == 1) {
            Symbol tripleSymbol = row[0];
            int multiplier = tripleSymbol.getTripleMultiplier();
            System.out.println("Triple " + tripleSymbol + "! Multiplier: " + multiplier + "x");
            return bet * multiplier;
        } else if (distinctCount == 2) {
            Symbol matching = findMatchingSymbol(row);
            int multiplier = matching.getDoubleMultiplier();
            System.out.println("Two of a kind: " + matching + "! Multiplier: " + multiplier + "x");
            return bet * multiplier;
        }

        System.out.println("No matches.");
        return 0;
    }

    /** Finds the symbol that appears more than once in the row. */
    private Symbol findMatchingSymbol(Symbol[] row) {
        if (row[0] == row[1] || row[0] == row[2]) {
            return row[0];
        }
        return row[1];
    }
}
