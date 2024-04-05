package software.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegersFromTheUser {
    private final ArrayList<Integer> inputConfig = new ArrayList<>();

    public IntegersFromTheUser(ArrayList<Integer> p){
        this.inputConfig.addAll(p);
    }

    // Constructor to read integers from a file
    public IntegersFromTheUser(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                this.inputConfig.add(num);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getIntegersFromTheUser(){   
        return inputConfig;
    }
} 