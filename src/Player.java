public class Player {
    //FIELDS
    private int balance; //player balance;


    //CONSTRUCTOR
    //initializes the balance the player starts with
    public Player(int startingBalance) {
        this.balance = startingBalance;
    }

    //GETTERS
    public int getBalance() {
        return balance;
    }

    //METHODS

    //place a bet - boolean to check if bet is valid
    public boolean placeBet(int amount) {
        //bet must be positive and less than or equal to balance
        if (amount > 0 && amount <= balance) {
            //subtracts from balance if the bet is valid
            balance -= amount;
            return true;
        }
        //invalid bet
        return false;
    }

    //add winnings to balance after a successful spin
    public void addWinnings(int amount) {
        balance += amount;
    }
}
