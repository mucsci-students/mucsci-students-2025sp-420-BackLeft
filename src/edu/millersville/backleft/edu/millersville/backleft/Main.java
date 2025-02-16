package edu.millersville.backleft;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        printWelcome();        
        promptDiagramSource();
        System.out.println("\n\n Input Loop Exited With No Issues :)\n\nGoodbye!");
        System.out.println("\n\n *** EXITING PROGRAM *** ");
    }

    //print basic welcome at start before user prompt main loop
    public static void printWelcome(){
        System.out.print("Welcome to Back Left UML Designer!\n\nEnter one of the available commands to get started.\n\n");
    }


    // FIRST SET OF PROMPTS to Load or Create New DIagram
    public static void promptDiagramSource(){

        Scanner userinput = new Scanner(System.in);
        System.out.print("'New'--> Create New Diagram\n'Load' --> Load Saved Diagram\n'Help' --> Show Help Menu\n'Quit' or 'Exit' to exit.\n\n");
        while (true){
            System.out.print("User :>\t");
            String command = userinput.nextLine();
            
            if (command.equals("New") || command.equals("new"))
            {
                createNewDiagram();
                break;
            }
            else if(command.equals("Load") || command.equals( "load"))
            {
                loadSavedDiagram();
                break;
            }
            else if(command.equals("Help") || command.equals("help"))
            {
                printHelpMenu();
            }
            else if(command.equals("Exit") || command.equals("exit")|| command.equals("Quit") || command.equals("quit"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid command. enter 'New', 'Load', or 'Help'     (Not case sensitive)\n\n");
            }
        }
            userinput.close();


    }



    public static void loadSavedDiagram(){
        System.out.println("\n\n ** LOADING DIAGRAM FROM JSON..... (next set of prompts for diagram name, or filepath) **");    
    }

    public static void printHelpMenu(){
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

    public static void createNewDiagram() {
        Scanner scanner = new Scanner(System.in);
        Diagram diagram = new Diagram();

        while (true) {
            System.out.print("Enter the name of the UML class (or type 'done' to finish): ");
            String className = scanner.nextLine();
            if (className.equalsIgnoreCase("done")) {
                break;
            }
            UmlClass umlClass = new UmlClass(className);
            diagram.addClass(umlClass);
            System.out.println("Class " + className + " created.");
        }

        System.out.println("Do you want to create relationships between the classes? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            createRelationships(scanner, diagram);
        }

        System.out.println("Diagram creation complete.");
    }

    private static void createRelationships(Scanner scanner, Diagram diagram) {
        while (true) {
            System.out.println("Available classes: " + diagram.getClassNames());
            System.out.print("Enter the name of the source class (or type 'done' to finish): ");
            String sourceClassName = scanner.nextLine();
            if (sourceClassName.equalsIgnoreCase("done")) {
                break;
            }
            UmlClass sourceClass = findClassByName(diagram.getClassNames(), sourceClassName);
            if (sourceClass == null) {
                System.out.println("Class " + sourceClassName + " not found.");
                continue;
            }
    
            List<String> targetClassNames = new ArrayList<>(diagram.getClassNames());
            targetClassNames.remove(sourceClassName);
            System.out.println("Available target classes: " + targetClassNames);
            System.out.print("Enter the name of the target class: ");
            String targetClassName = scanner.nextLine();
            UmlClass targetClass = findClassByName(targetClassNames, targetClassName);
            if (targetClass == null) {
                System.out.println("Class " + targetClassName + " not found.");
                continue;
            }
    
            System.out.print("Enter the type of relationship (e.g., Aggregation, Composition, Generalization): ");
            String relationshipType = scanner.nextLine();
            Relationship relationship = new Relationship(sourceClass, targetClass, relationshipType);
            diagram.addRelationship(relationship);
            System.out.println(diagram.toString());
        }
    }
    
    private static UmlClass findClassByName(List<String> classNames, String className) {
        for (String name : classNames) {
            if (name.equalsIgnoreCase(className)) {
                return new UmlClass(name);
            }
        }
        return null;
    }

}

