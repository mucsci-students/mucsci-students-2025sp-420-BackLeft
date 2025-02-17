package edu.millersville.backleft;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class DiagramManager {
    private static final String FILE_NAME = "diagram.json";

    // Save the diagram to a JSON file
    public static void saveDiagram(Diagram diagram) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(diagram, writer);
            System.out.println("Diagram saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the diagram from a JSON file
    public static Diagram loadDiagram() {
        Gson gson = new Gson();
        Type diagramType = new TypeToken<Diagram>() {}.getType();
        
        try (FileReader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, diagramType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Directory where diagrams are stored (update path if needed)
    String diagramDirectory = "diagrams/"; 
    File dir = new File(diagramDirectory);
    
    // Check if directory exists
    if (!dir.exists() || !dir.isDirectory()) {
        System.out.println("No saved diagrams found.\n");
        return;
    }

    // Get list of files in the directory
    File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
    if (files == null || files.length == 0) {
        System.out.println("No saved diagrams found.\n");
        return;
    }

    // Print available diagrams
    System.out.println("Choose a diagram to load:");
    for (int i = 0; i < files.length; i++) {
        System.out.println((i + 1) + ". " + files[i].getName().replace(".json", ""));
    }

    // Get user input
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nEnter the number of the diagram to load: ");
    
    int choice;
    try {
        choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > files.length) {
            System.out.println("Invalid choice. Returning to main menu.");
            return;
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Returning to main menu.");
        return;
    }

    // Load the chosen diagram
    String fileName = files[choice - 1].getName();
//     Diagram loadedDiagram = DiagramManager.loadDiagram(fileName);

//     if (loadedDiagram != null) {
//         System.out.println("\nSuccessfully loaded diagram: " + loadedDiagram.getDiagramName());
//         createNewDiagram();
//     } else {
//         System.out.println("Failed to load diagram. Please try again.");
//     }
    }

    

    @Override
    public String toString() {
        return "DiagramManager []";
    }

}
