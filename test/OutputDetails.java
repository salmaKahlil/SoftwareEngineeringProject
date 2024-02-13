package test;

import java.util.ArrayList;

public class OutputDetails {
    //get integers from the user as array and i will set it to the array declared
    
    private ArrayList<String> outputConfig = new ArrayList<String>();

    void setOutputDetails(ArrayList<String> p){
        //from the compute engine
        outputConfig = p;

    }
    ArrayList<String> getOutputDetails(){   
        return outputConfig;

    }
}
