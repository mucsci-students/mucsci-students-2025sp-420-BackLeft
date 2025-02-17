package edu.millersville.backleft;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

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
    }

    public static void main(String[] args) {
        // Create a new diagram
        Diagram diagram = new Diagram("UML Example");

        // Adding UML Classes
        UmlClass classA = new UmlClass("ClassA");
        UmlClass classB = new UmlClass("ClassB");

        classA.addAttribute("id", "int");
        classA.addAttribute("name", "String");

        classB.addAttribute("value", "double");

        diagram.addClass(classA);
        diagram.addClass(classB);

        // Adding a Relationship
        Relationship rel = new Relationship(classA, classB, "Association");
        diagram.addRelationship(rel);

        // Save to JSON
        saveDiagram(diagram);

        // Load and print
        Diagram loadedDiagram = loadDiagram();
        if (loadedDiagram != null) {
            System.out.println("Loaded Diagram: " + loadedDiagram);
        }
    }

    @Override
    public String toString() {
        return "DiagramManager []";
    }
}
