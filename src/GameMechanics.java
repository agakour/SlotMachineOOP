import java.util.Random;

public class GameMechanics {
    //fields
    private final Random random;

    //constructor
    public GameMechanics() {
        this.random = new Random();
    }

    // method to spin a row of 3 symbols
    public Symbol[] spinRow() {
        Symbol[] row = new Symbol[3];
        for (int i = 0; i < row.length; i++) {
            row[i] = Symbol.getRandomSymbol(random);
        }
        return row;
    }

    // method to print the row
    public void printRow(Symbol[] row) {
        System.out.println("**************");
        for (Symbol s : row) {
            System.out.print(s + " | ");
        }
        System.out.println("\n**************");
    }
}

