import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputDetails {
    
    private String filePath;

    public OutputDetails(String filePath){
        this.filePath = filePath;
    }

    public void outputDetailsMethod(String delimiter, String result, String input ){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(input);
            writer.write(":");
            writer.write(result);
            writer.write(delimiter);
            writer.write(" ");

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}