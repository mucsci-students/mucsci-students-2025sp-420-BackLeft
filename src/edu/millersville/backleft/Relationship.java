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

    private boolean isValidType(String type) { 
        return type.equals(AGGREGATION) || type.equals(COMPOSITION) || type.equals(ASSOCIATION) || type.equals(GENERALIZATION);
    }

    public Class getRootClass() {
        return rootClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public String getType() {
        return type;
    }

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
}