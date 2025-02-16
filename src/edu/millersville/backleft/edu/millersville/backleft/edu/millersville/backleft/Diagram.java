package edu.millersville.backleft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Diagram {

    private String diagramName;
    private List<UmlClass> classDefinitons;
    private HashSet<Object> objectInstances; // Added initialization for objectInstances
    private HashSet<String> classNames;
    private List<Relationship> relationships;

    public Diagram() {
        this.diagramName = "Untitled";
        this.classDefinitons = new ArrayList<>();
        this.classNames = new HashSet<>();
        this.relationships = new ArrayList<>();
        this.objectInstances = new HashSet<>();
    }

    public Diagram(String name) {
        this.diagramName = name;
        this.classDefinitons = new ArrayList<>();
        this.classNames = new HashSet<>();
        this.relationships = new ArrayList<>();
        this.objectInstances = new HashSet<>();
    }

    public String getDiagramName() {
        return this.diagramName;
    }

    public int getObjectCount() {
        return this.objectInstances.size();
    }

    public int getClassCount() {
        return this.classDefinitons.size();
    }

    public int getRelationshipCount() {
        return relationships.size();
    }

    public List<String> getClassNames() {
        ArrayList<String> classlist = new ArrayList<>();
        for (String cls : classNames) {
            classlist.add(cls);
        }
        return classlist;
    }

    public void addClass(UmlClass umlclass) {
        if (classNames.contains(umlclass.getClassName())) {
            return;
        }
        classDefinitons.add(umlclass);
        classNames.add(umlclass.getClassName());
    }

    private UmlClass findClassByName(String className) {
        for (UmlClass umlClass : classDefinitons) {
            if (umlClass.getClassName().equalsIgnoreCase(className)) {
                return umlClass;
            }
        }
        return null;
    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public void removeRelationship(Relationship relationship) {
        relationships.remove(relationship);
    }

    public void addObjectInstance(Object obj) {
        // Implementation here
    }

    public void createRelationships(Scanner scanner) {
        while (true) {
            System.out.println("Available classes: " + getClassNames());
            System.out.print("Enter the name of the source class (or type 'done' to finish): ");
            String sourceClassName = scanner.nextLine();
            if (sourceClassName.equalsIgnoreCase("done")) {
                break;
            }
            UmlClass sourceClass = findClassByName(sourceClassName);
            if (sourceClass == null) {
                System.out.println("Class " + sourceClassName + " not found.");
                continue;
            }

            List<String> targetClassNames = new ArrayList<>(getClassNames());
            targetClassNames.remove(sourceClassName);
            System.out.println("Available target classes: " + targetClassNames);
            System.out.print("Enter the name of the target class: ");
            String targetClassName = scanner.nextLine();
            UmlClass targetClass = findClassByName(targetClassName);
            if (targetClass == null) {
                System.out.println("Class " + targetClassName + " not found.");
                continue;
            }

            while (true) {
                System.out.print("Enter the type of relationship (e.g., Aggregation, Composition, Association, Generalization): ");
                String relationshipType = scanner.nextLine();
                try {
                    Relationship relationship = new Relationship(sourceClass, targetClass, relationshipType);
                    addRelationship(relationship);
                    System.out.println("Relationship added: " + relationship);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(toString());
        }
    }

    // Method to add attributes to a class
    public void addAttributesToClass(Scanner scanner) {
        System.out.println("Available classes: " + getClassNames());
        System.out.print("Enter the name of the class to add attributes to: ");
        String className = scanner.nextLine();
        UmlClass umlClass = findClassByName(className);
        if (umlClass == null) {
            System.out.println("Class " + className + " not found.");
            return;
        }

        while (true) {
            System.out.print("Enter the name of the attribute (or type 'done' to finish): ");
            String attributeName = scanner.nextLine();
            if (attributeName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter the type of the attribute: ");
            String attributeType = scanner.nextLine();
            umlClass.addAttribute(attributeName, attributeType);
            System.out.println("Attribute " + attributeName + " of type " + attributeType + " added to class " + className + ".");
        }
    }

    // Method to view attributes of a class
    public void viewAttributesOfClass(Scanner scanner) {
        System.out.println("Available classes: " + getClassNames());
        System.out.print("Enter the name of the class to view attributes: ");
        String className = scanner.nextLine();
        UmlClass umlClass = findClassByName(className);
        if (umlClass == null) {
            System.out.println("Class " + className + " not found.");
            return;
        }

        System.out.println("Attributes of class " + className + ":");
        for (Map.Entry<String, String> entry : umlClass.getAttributes().entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Diagram: ").append(diagramName).append("\nClasses:\n");
        for (UmlClass umlClass : classDefinitons) {
            sb.append("  ").append(umlClass.getClassName()).append("\n");
        }
        sb.append("Relationships:\n");
        for (Relationship relationship : relationships) {
            sb.append("  ").append(relationship.toString()).append("\n");
        }
        return sb.toString();
    }
}