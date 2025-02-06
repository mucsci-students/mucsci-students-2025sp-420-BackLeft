package edu.millersville.backleft;

import java.util.HashMap;
import java.util.Map;

/**
 * A versatile data object representing a single row in a database table.
 * This class dynamically stores column names and their associated values.
 */
public class Class {

    private final String className; 
    private final Map<String, Object> fields; 




    /**
     *  CONSTRUCTORS
     */
    public Class()
    {
        this("", new HashMap<>());
    }

    public Class(Class original)
    {
        this.className = original.getClassName();
        this.fields = new HashMap<>(original.fields);
    }   


    public Class(String className)
    {
        this(className, new HashMap<>());
    }

    public Class(String className, Map<String, Object> fields)
    {
        this.className = className;
        this.fields = fields != null ? new HashMap<>(fields) : new HashMap<>();
    }


    /**
     *  Class methods
     */

    // Get the name of the class instance
    public String getClassName()
    {
        return className;
    }


    /**
     * Attribute/field methods of the class instance
     */

    // Get the value of a specific field
    public Object getField(String fieldName)
    {
        return fields.get(fieldName);
    }

    // Get all fields
    public Map<String, Object> getAllFields()
    {
        return new HashMap<>(fields);
    }

    // Set or update a field value
    public void setField(String fieldName, Object value)
    {
        fields.put(fieldName, value);
    }

    // Remove a field
    public void removeField(String fieldName)
    {
        fields.remove(fieldName);
    }

    // Check if a field exists
    public boolean hasField(String fieldName)
    {
        return fields.containsKey(fieldName);
    }

    // Convert the DataObject to a string (useful for debugging)
    @Override
    public String toString()
    {
        return getClassName() +" {" + "\nattributes=" + fields +"\n}";
    }
}
