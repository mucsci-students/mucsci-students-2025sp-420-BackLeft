package edu.millersville.backleft;

import java.util.HashMap;
import java.util.Map;

public class UmlClass {
    private final String className;
    private final Map<String, String> attributes; // Field name -> Type
    private final Map<String, String> methods;    // Method name -> Return Type

    // Constructor for a 'Class' object
    public UmlClass(String className) {
        this.className = className;
        this.attributes = new HashMap<>();
        this.methods = new HashMap<>();
    }

    // Retrieves the name of an instance of 'Class'
    public String getClassName() {
        return className;
    }

    // Adds an attribute to an instance of 'Class' and stores it in a HashMap
    public void addAttribute(String name, String type) {
        attributes.put(name, type);
    }
    

    // Creates a new method within an instance of a 'Class'
    public void addMethod(String name, String returnType) {
        methods.put(name, returnType);
    }

    // Returns the attributes contained within an instance of 'Class'
    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }

    // Returns the methods contained within an instance of 'Class'
    public Map<String, String> getMethods() {
        return new HashMap<>(methods);
    }

    // Prints a 'Class' with all of its attributes and methods
    @Override
    public String toString() {
        return "Class: " + className + "\nAttributes: " + attributes + "\nMethods: " + methods;
    }
}
