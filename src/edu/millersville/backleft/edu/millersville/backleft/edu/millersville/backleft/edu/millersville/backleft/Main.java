package edu.millersville.backleft;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printWelcome();
        promptDiagramSource();
        System.out.println("\n\n Input Loop Exited With No Issues :)\n\nGoodbye!");
        System.out.println("\n\n *** EXITING PROGRAM *** ");
    }

    // Print basic welcome at start before user prompt main loop
    public static void printWelcome() {
        System.out.print("Welcome to Back Left UML Designer!\n\nEnter one of the available commands to get started.\n\n");
    }

    // First set of prompts to load or create new diagram
    public static void promptDiagramSource() {
        Scanner userinput = new Scanner(System.in);
        System.out.print("'New'--> Create New Diagram\n'Load' --> Load Saved Diagram\n'Help' --> Show Help Menu\n'Quit' or 'Exit' to exit.\n\n");
        while (true) {
            System.out.print("User :>\t");
            String command = userinput.nextLine();

            if (command.equalsIgnoreCase("New")) {
                createNewDiagram();
                break;
            } else if (command.equalsIgnoreCase("Load")) {
                loadSavedDiagram();
                break;
            } else if (command.equalsIgnoreCase("Help")) {
                printHelpMenu();
            } else if (command.equalsIgnoreCase("Exit") || command.equalsIgnoreCase("Quit")) {
                break;
            } else {
                System.out.println("Invalid command. Enter 'New', 'Load', or 'Help' (Not case sensitive)\n\n");
            }
        }
        userinput.close();
    }


    public static void printHelpMenu() {
        System.out.println("\n\n ** Help Menu **");
        System.out.println("\n=== Class Diagram Program Help Menu ===");
        System.out.println("Usage:");
        System.out.println("  java HelpMenuCLI [options]\n");
        System.out.println("Options:");
        System.out.println("  -h, --help      Show this help menu\n");
        System.out.println("Interactive Commands:");
        System.out.println("  command              Display this command menu");
        System.out.println("  exit                 Exit the program\n");
        System.out.println("  new                  Create a new Class Diagram\n");
        System.out.println("  save                 Save the current Class Diagram\n");
        System.out.println("  load                 Load a saved Class Diagram\n");
        System.out.println("  add class            Add a class\n");
        System.out.println("  remove class         Remove a class\n");
        System.out.println("Description:");
        System.out.println("  This program is a command-line tool designed to help you create and manage");
        System.out.println("  class diagrams. You can use it to define classes, their attributes, methods,");
        System.out.println("  and relationships (e.g., inheritance, composition, etc.).");
        System.out.println("========================================\n");
    }

    public static void createNewDiagram() {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the name of the diagram
        System.out.print("Enter the name of the diagram: ");
        String diagramName = scanner.nextLine();
        Diagram diagram = new Diagram(diagramName);

        System.out.println("Diagram created successfully.");
        System.out.println("Would you like to save the diagram or edit it?");
        System.out.println("1. Save");
        System.out.println("2. Edit");
        System.out.println("3. Exit");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            saveDiagram(diagram);
        } else if (choice.equals("2")) {
            editDiagram(scanner, diagram);
        }else if(choice.equals("3")){
            System.out.println("Exiting...");
            promptDiagramSource();
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
            promptDiagramSource();
        }
    }

    private static void addClassToDiagram(Scanner scanner, Diagram diagram, String className) {
        UmlClass umlClass = new UmlClass(className);
        diagram.addClass(umlClass);
        System.out.println("Class " + className + " created.");
        System.out.println("Do you want to add attributes to this class? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            diagram.addAttributesToClass(scanner);
        }
    }

    public static void editDiagram(Scanner scanner, Diagram diagram){
        // Main loop for further actions
        while (true) {
            System.out.println("What would you like to do next?");
            System.out.println("1. Add class");
            System.out.println("2. Add relationship");
            System.out.println("3. View attributes of a class");
            System.out.println("4. Add attributes to a class");
            System.out.println("5. Print diagram");
            System.out.println("6. Save diagram");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                System.out.print("Enter the name of the UML class (or type 'done' to finish): ");
                String className = scanner.nextLine();
            if (className.equalsIgnoreCase("done")) {
                break;
            }
            addClassToDiagram(scanner, diagram, className);
                    break;
                case "2":
                    diagram.createRelationships(scanner);
                    break;
                case "3":
                    diagram.viewAttributesOfClass(scanner);
                    break;
                case "4":
                    diagram.addAttributesToClass(scanner);
                    break;
                case "5":
                    System.out.println(diagram.toString());
                    break;
                case "6":
                    saveDiagram(diagram);
                    break;
                case "7":
                    System.out.println("Exiting...");
                    promptDiagramSource();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void saveDiagram(Diagram diagram) {
        // Implementation for saving the diagram
        DiagramManager.saveDiagram(diagram);
        System.out.println("Diagram saved.");
    }

    public static void loadSavedDiagram() {
    System.out.println("\n\n ** Available Saved Diagrams **");
    DiagramManager manager = new DiagramManager();
    //editDiagram(manager.loadDiagram());
    }
}