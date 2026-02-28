import java.util.Scanner;

/**
 * Handles user interaction and the main game loop.
 */
public class Menu {
    private final GameMechanics mechanics;
    private final Scanner scanner;
    private final Player player;

    public Menu() {
        this.mechanics = new GameMechanics();
        this.scanner = new Scanner(System.in);
        this.player = new Player(100);
    }

    /** Displays the main menu and runs the game loop until the player exits or runs out of money. */
    public void showMenu() {
        System.out.println("**********************************");
        System.out.println("🍒 Welcome to Java Slot Machine 🍒");
        System.out.println("**********************************");
        System.out.println();

        boolean running = true;
        // loop until player chooses to exit OR runs out of money
        while (running && player.getBalance() > 0) {
            System.out.println("Balance: $" + player.getBalance());
            System.out.println("-------------------------------");
            System.out.println("1 - 🎰 Spin the slot");
            System.out.println("2 - 🚪 Exit");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            // handle menu choices
            switch (choice) {
                case "1" -> spinSlot();
                case "2" -> running = false;
                default -> System.out.println("Invalid option. Try again!");
            }
        }

        // goodbye / game over message
        System.out.println("==================================");
        if (player.getBalance() <= 0) {
            System.out.println("💀 GAME OVER! You ran out of money!");
        } else {
            System.out.println("👋 Thanks for playing!");
        }
        System.out.println("Final balance: $" + player.getBalance());
        System.out.println("==================================");
    }

    /** Handles a single spin round: bet input, spinning, and payout. */
    private void spinSlot() {
        int bet = 0;
        boolean validBet = false;

        while (!validBet) {
            System.out.print("🎲 Enter your bet (Balance: $" + player.getBalance() + ") or 0 to cancel: ");
            String input = scanner.nextLine().trim();

            try {
                bet = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                try {
                    Double.parseDouble(input);
                    System.out.println("Decimal bets are not allowed! Please enter a whole number.");
                } catch (NumberFormatException e2) {
                    System.out.println("Invalid input! Please enter a whole number.");
                }
                continue;
            }

            if (bet == 0) {
                System.out.println("Bet cancelled.");
                return;
            }

            // validate bet range
            if (bet < 0) {
                System.out.println("Bet must be a positive number.");
                continue;
            } else if (bet > player.getBalance()) {
                System.out.println("Bet cannot exceed your current balance of $" + player.getBalance());
                continue;
            }

            validBet = true;
        }

        player.placeBet(bet);

        // spin with a short delay for effect
        System.out.println();
        System.out.println("🎰 Spinning...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Symbol[] row = mechanics.spinRow();
        mechanics.printRow(row);

        int payout = mechanics.getPayout(row, bet);

        if (payout > 0) {
            System.out.println("🎉 You won $" + payout + "!");
            player.addWinnings(payout);
        } else {
            System.out.println("💸 Sorry, you lost $" + bet + " this round.");
        }
        System.out.println();
    }

    /** Closes the scanner resource. */
    public void close() {
        scanner.close();
    }
}
