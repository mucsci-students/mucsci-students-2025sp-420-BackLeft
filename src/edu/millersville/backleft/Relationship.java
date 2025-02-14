package edu.millersville.backleft;

/**
 * A versatile data object representing a relationship between two UML classes.
 */
public class Relationship {

    public static final String AGGREGATION = "Aggregation";
    public static final String COMPOSITION = "Composition";
    public static final String ASSOCIATION = "Association";
    public static final String GENERALIZATION = "Generalization";

    private final Class rootClass;
    private final Class targetClass;
    private final String type;

    /**
     * Constructor for Relationship. Checks if the type is valid and if classes are specified.
     * @param rootClass the root class in the relationship
     * @param targetClass the target class in the relationship
     * @param type the type of relationship
     */
    public Relationship(Class rootClass, Class targetClass, String type) {
        if (rootClass == null || targetClass == null) {
            throw new IllegalArgumentException("Must choose two classes to create a relationship");
        }
        if (!isValidType(type)) { 
            throw new IllegalArgumentException("Valid types are: " + AGGREGATION + ", " + COMPOSITION + ", " + ASSOCIATION + ", " + GENERALIZATION);
        }
        this.rootClass = rootClass;
        this.targetClass = targetClass;
        this.type = type;
    }

    /**
     * Checks if the type of relationship is valid.
     * @param type the type of relationship
     * @return true if the type is valid, false otherwise
     */
    private boolean isValidType(String type) { 
        return type.equals(AGGREGATION) || type.equals(COMPOSITION) || type.equals(ASSOCIATION) || type.equals(GENERALIZATION);
    }

     /**
     * Returns the root class.
     * @return the root class
     */
    public Class getRootClass() {
        return rootClass;
    }

    /**
     * Returns the target class.
     * @return the target class
     */
    public Class getTargetClass() {
        return targetClass;
    }

    /**
     * Returns the type of relationship.
     * @return the type of relationship
     */
    public String getType() {
        return type;
    }

    /**
     * Checks relationship type and returns a string with root, relationship, target.
     * @return a string representation of the relationship
     */
    @Override
    public String toString() {
        String relationshipSymbol;
        switch (type) {
            case AGGREGATION:
                relationshipSymbol = " ------<> ";
                break;
            case COMPOSITION:
                relationshipSymbol = " ------<*> ";
                break;
            case ASSOCIATION:
                relationshipSymbol = " -------- ";
                break;
            case GENERALIZATION:
                relationshipSymbol = " ------> ";
                break;
            default:
                relationshipSymbol = " ---???- ";
                break;
        }
        return rootClass.getClassName() + relationshipSymbol + targetClass.getClassName();
    }

    /**
     * Checks if this relationship is equal to another object.
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationship that = (Relationship) o;
        return Objects.equals(rootClass, that.rootClass) &&
               Objects.equals(targetClass, that.targetClass) &&
               Objects.equals(type, that.type);
    }

    /**
     * Returns the hash code for this relationship.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(rootClass, targetClass, type);
    }
}