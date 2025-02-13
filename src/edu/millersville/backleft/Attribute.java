package edu.millersville.backleft;

/**
 * A versatile data object representing an Attribute of a class.
 */
public class Attribute {

    private final Class rootClass;
    private final String type;
    private final String name;

    /**
     * Constructor for Attribute. Checks if the type is valid and if class are specified.
     * @param Class the root class in the Attribute
     * @param type the type of value
     * @param name the name of the Attribute
     */
    public Attribute(Class class, String type, String name) {
        if (class == null || name == null || type == null) {
            throw new IllegalArgumentException("Need a class, name and type to create an Attribute");
        }
        
        this.rootClass = rootClass;
        this.targetClass = targetClass;
        this.type = type;
    }

    /**
     
    private boolean isValidType(String type) { 
        return 0;
    }
    */

     /**
     * Returns the class.
     * @return the class
     */
    public Class getClass() {
        return class;
    }

     /**
     * Returns the name.
     * @return the name
     */
    public Class getName() {
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
        
    }
}