package software.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputDetails {

    private final String fileName;

    public OutputDetails(String fileName){
        this.fileName = fileName;
        // Create the file if it doesn't exist
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.close(); // Close immediately to create an empty file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputDetailsMethod(String delimiter, String result, String input ){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(input);
            writer.write(":");
            writer.write(result);
            writer.write(delimiter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
