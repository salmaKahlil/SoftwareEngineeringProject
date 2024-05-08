package software.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputDetails {
    
    private final String filePath;

    public OutputDetails(String filePath){
        this.filePath = filePath;
    }

    public void outputDetailsMethod(String delimiter, String result, String input ){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(input);
            writer.write(":");
            writer.write(result);
            writer.write(delimiter);

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
