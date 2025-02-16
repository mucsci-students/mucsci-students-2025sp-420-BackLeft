package edu.millersville.backleft;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CommandLine {

    //Save to JSON
    public void saveToJson(String filePath) {
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


}