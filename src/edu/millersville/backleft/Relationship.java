package edu.millersville.backleft;

/**
 * A versatile data object representing a single row in a database table.
 * This class dynamically stores column names and their associated values.
 */
public class Relationship {

    private final Object rootObject;
    private final Object targetObject; 
    private final String type;


    public Relationship(Object rootObject, Object targetObject, String type)
    {
        this.rootObject = rootObject;
        this.targetObject = targetObject;
        this.type = type;
    }



    public Object getRootObject()
    {
        return rootObject;
    }

    public Object getTargetObject()
    {
        return targetObject;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return rootObject.toString() + " ---" + type + "--> " + targetObject.toString();
    }
}
