package test;

import java.util.ArrayList;

public interface Data {
    //function called dataIn that takes integers of type int and return an array of integers 
    public ArrayList<Integer> dataIn(IntegersFromTheUser numbers); 
    //boolean for now
    public ArrayList<String> computationEndMessage(OutputDetails results);
} 
