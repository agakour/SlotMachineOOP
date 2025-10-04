import java.util.Scanner;

public class Menu {
    //FIELDS
    private final GameMechanics mechanics; // game mechanics instance - handles spins and payouts
    private final Scanner scanner; // scanner for user input
    private final Player player; // player instance - manages balance and bets

    //CONSTRUCTOR
    // initializes game mechanics, scanner, and player with a starting balance
    public Menu() {
        this.mechanics = new GameMechanics();
        this.scanner = new Scanner(System.in);
        this.player = new Player(100);
    }

    //METHODS

    // show main menu loop
    public void showMenu() {
        System.out.println("**********************************");
        System.out.println("🍒 Welcome to Java Slot Machine 🍒");
        System.out.println("**********************************");

        boolean running = true;
        // loop until player chooses to exit OR runs out of money
        while (running && player.getBalance() > 0) {
            System.out.println("\nBalance: $" + player.getBalance());
            System.out.println("1 - Spin the slot");
            System.out.println("2 - Exit");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            // handle menu choices
            switch (choice) {
                case "1" -> spinSlot();
                case "2" -> {
                    System.out.println("Thanks for playing!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }

        // game over message
        System.out.println("GAME OVER! Final balance: $" + player.getBalance());
    }

    //METHODS

    // single slot spin
    private void spinSlot() {
        System.out.print("Enter your bet: ");
        int bet;
        // validate bet input - must be a number and within balance
        try {
            bet = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Enter a number.");
            return;
        }
        if (!player.placeBet(bet)) {
            System.out.println("Invalid bet. You must bet a positive amount within your balance.");
            return;
        }
        // perform the spin
        System.out.println("Spinning...");
        Symbol[] row = mechanics.spinRow();
        mechanics.printRow(row);
        // calculate and display payout
        int payout = mechanics.getPayout(row, bet);
        // update player balance if there's a payout
        if (payout > 0) {
            System.out.println("You won $" + payout + "!");
            player.addWinnings(payout);
        } else {
            System.out.println("Sorry, you lost this round.");
        }
    }

    // close scanner
    public void close() {
        scanner.close();
    }
}
