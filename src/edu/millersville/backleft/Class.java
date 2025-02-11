package edu.millersville.backleft;

import java.util.HashMap;
import java.util.Map;

public class Class {
    private final String className;
    private final Map<String, String> attributes; // Field name -> Type
    private final Map<String, String> methods;    // Method name -> Return Type

    public Class(String className) {
        this.className = className;
        this.attributes = new HashMap<>();
        this.methods = new HashMap<>();
    }

    public String getClassName() {
        return className;
    }

    public void addAttribute(String name, String type) {
        attributes.put(name, type);
    }

    public void addMethod(String name, String returnType) {
        methods.put(name, returnType);
    }

    public Map<String, String> getAttributes() {
        return new HashMap<>(attributes);
    }

    public Map<String, String> getMethods() {
        return new HashMap<>(methods);
    }

    @Override
    public String toString() {
        return "Class: " + className + "\nAttributes: " + attributes + "\nMethods: " + methods;
    }
}
