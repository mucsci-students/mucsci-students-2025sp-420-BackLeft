package edu.millersville.backleft;

/**
 * A versatile data object representing an Attribute of a class.
 */
public class Attribute {

    private final UmlClass rootClass;
    private final String type;
    private final String name;

    /**
     * Constructor for Attribute. Checks if the type is valid and if class are specified.
     * @param rootClass the root class in the Attribute
     * @param type the type of value
     * @param name the name of the Attribute
     */
    public Attribute(UmlClass rootClass, String type, String name) {
        if (rootClass == null || name == null || type == null) {
            throw new IllegalArgumentException("Need a class, name and type to create an Attribute");
        }
        
        this.rootClass = rootClass;
        this.type = type;
        this.name = name;
    }

    /**
     * Returns the class.
     * @return the class
     */
    public UmlClass getRootClass() {
        return rootClass;
    }

    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    

    /**
     * Returns the type.
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
    */
    @Override
    public String toString() {
        return "Attribute{" + type + ": " + name  + "', rootClass=" + rootClass + "}";
    }
}