import java.util.Scanner;

public class HelpMenu {

    public static void main(String[] args) {
        // Check if the user provided a command-line argument for help
        if (args.length > 0 && (args[0].equals("--help") || args[0].equals("-h"))) {
            printHelpMenu();
            return;
        }

        // Start an interactive CLI session
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Class Diagram Program Help Menu.");
        System.out.println("Type 'command' to display the list of available commands or 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("command")) {
                printHelpMenu();
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Unrecognized command: \"" + input + "\"");
                System.out.println("Type 'help' for the help menu.");
            }
        }

        scanner.close();
    }

    /**
     * Prints the help menu to the terminal.
     */
    private static void printHelpMenu() {
        System.out.println("\n=== Class Diagram Program Help Menu ===");
        System.out.println("Usage:");
        System.out.println("  java HelpMenuCLI [options]\n");
        System.out.println("Options:");
        System.out.println("  -h, --help      Show this help menu\n");
        System.out.println("Interactive Commands:");
        System.out.println("  command              Display this command menu");
        System.out.println("  exit                 Exit the program\n");
        System.out.println("  new                  Create a new Class Diagram\n");
        System.out.println("  save                 Save the current CLass Diagram\n");
        System.out.println("  load                 Load a saved Class Diagram\n");
        System.out.println("  add class            Add a class\n");
        System.out.println("  remove class         Remove a class\n");
        System.out.println("Description:");
        System.out.println("  This program is a command-line tool designed to help you create and manage");
        System.out.println("  class diagrams. You can use it to define classes, their attributes, methods,");
        System.out.println("  and relationships (e.g., inheritance, composition, etc.).");
        System.out.println("========================================\n");
    }
}
