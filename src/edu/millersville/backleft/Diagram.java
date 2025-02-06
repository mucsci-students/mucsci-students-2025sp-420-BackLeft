package edu.millersville.backleft;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Diagram {
    private String diagramName;
    private List<Class> classes;
    private List<Relationship> relationships;

    public Diagram(String name) {
        this.diagramName = name;
        this.classes = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public void addClass(Class umlclass) {
        classes.add(umlclass);
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    // Convert to JSON and save
    public void saveToJson(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load from JSON
    public static Diagram loadFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Diagram.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Diagram: " + diagramName + "\nClasses: " + classes + "\nRelationships: " + relationships;
    }
}
