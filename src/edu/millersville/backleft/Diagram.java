package edu.millersville.backleft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A versatile data object representing a single row in a database table.
 * This diagram dynamically stores column names and their associated values.
 */
public class Diagram {

    private final String diagramName;
    private HashSet<Class> classes; 
    private final Set<Object> relationships; 




    /**
     *  CONSTRUCTORS
     */
    public Diagram()
    {
        this("", new HashMap<>());
    }

    public Diagram(Diagram original)
    {
        this.diagramName = original.getDiagramName();
        this.fields = new HashMap<>(original.fields);
    }   


    public Diagram(String JSONFilePath)
    {
        //TODO ctor from JSON
    }

    public Diagram(String diagramName, Map<String, Object> fields)
    {
        this.diagramName = diagramName;
        this.fields = fields != null ? new HashMap<>(fields) : new HashMap<>();
    }


    /**
     *  Diagram methods
     */

    // Get the name of the diagram instance
    public String getDiagramName()
    {
        return diagramName;
    }


    /**
     * Attribute/field methods of the diagram instance
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
        return getDiagramName() +" {" + "\nattributes=" + fields +"\n}";
    }
}
