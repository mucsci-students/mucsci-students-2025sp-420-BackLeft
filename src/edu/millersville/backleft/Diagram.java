package edu.millersville.backleft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Diagram {

    private String diagramName;
    private List<Class> classDefinitons;
    private HashSet<Object> objectInstances;
    private HashSet<String> classNames;
    private List<Relationship> relationships;


    public Diagram() {
        this.diagramName = "Untitled";
        this.classDefinitons = new ArrayList<>();
        this.classNames = new HashSet<>(){};
        this.relationships = new ArrayList<>();
    }

    public Diagram(String name) {
        this.diagramName = name;
        this.classDefinitons = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }



    public String getDiagramName(){
        return this.diagramName;
    }

    public int getObjectCount() {
        return this.objectInstances.size();
    }

    public int getClassCount() {
        return this.objectInstances.size();
    }

    public int getRelationshipCount()
    {
        return relationships.size();
    }

    public List<String> getClassNames() {
        ArrayList<String> classlist = new ArrayList<String>();
        for(String cls : classNames) {
            classlist.add(cls);
        }
        return classlist;
    }


    public void addClass(Class umlclass) {
        
        if(classNames.contains(umlclass.getClassName()))
            return;
        
        classDefinitons.add(umlclass);
        classNames.add(umlclass.getClassName());

    }

    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }


    public void addObjectInstance(Object obj) {
        
    }






    // Convert to JSON and save
/**     public void saveToJson(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load from JSON
    public static Diagram loadFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Diagram.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
*/
    @Override
    public String toString() {
        return "Diagram: " + diagramName + "\nClasses: " + classes + "\nRelationships: " + relationships;
    }
}
