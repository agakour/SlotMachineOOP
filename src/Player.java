/**
 * Manages the player's balance and betting.
 */
public class Player {
    private int balance;

    public Player(int startingBalance) {
        this.balance = startingBalance;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * Deducts the bet from the balance if valid.
     * @return true if the bet was placed, false if invalid
     */
    public boolean placeBet(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /** Adds winnings to the player's balance. */
    public void addWinnings(int amount) {
        balance += amount;
    }
}
