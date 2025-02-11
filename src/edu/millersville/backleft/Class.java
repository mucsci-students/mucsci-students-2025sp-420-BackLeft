package edu.millersville.backleft;

import java.util.HashMap;
import java.util.Map;

public class Class {
    private final String className;
    private final Map<String, String> attributes; // Field name -> Type

    // Constructor for a 'Class' object
    public Class(String className) {
        this.className = className;
        this.attributes = new HashMap<>();
    }

    // Retrieves the name of an instance of 'Class'
    public String getClassName() {
        return className;
    }

    // Adds an attribute to an instance of 'Class' and stores it in a HashMap
    public void addAttribute(String name, String type) {
        attributes.put(name, type);
    }

    // Returns the attributes contained within an instance of 'Class'
    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }

    // Prints a 'Class' with all of its attributes
    @Override
    public String toString() {
        return "Class: " + className + "\nAttributes: " + attributes;
    }
}