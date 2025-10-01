import java.util.Scanner;

public class Menu {

    //fields
    private final GameMechanics mechanics;
    private final Scanner scanner;

    //constructor
    public Menu() {
        this.mechanics = new GameMechanics();
        this.scanner = new Scanner(System.in);
    }

    // main menu loop
    public void show() {
        System.out.println("**********************************");
        System.out.println("🍒 Welcome to Java Slot Machine 🍒");
        System.out.println("**********************************");

        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Spin the slot");
            System.out.println("2 - Exit");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> spinSlot();
                case "2" -> {
                    System.out.println("Thanks for playing!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }

    // method to handle spinning a row
    private void spinSlot() {
        Symbol[] row = mechanics.spinRow();
        mechanics.printRow(row);
        // Later: calculate payout
    }

    // close scanner
    public void close() {
        scanner.close();
    }
}

