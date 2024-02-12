package test;

import java.util.ArrayList;

public class IntegersFromTheUser {
    //get integers from the user as array and i will set it to the array declared
    
    private ArrayList<Integer> input = new ArrayList<Integer>();

    void setIntegersFromTheUser(ArrayList<Integer> p){
        input = p;

    }
    ArrayList<Integer> getIntegersFromTheUser(){   
        return input;

    }
}
