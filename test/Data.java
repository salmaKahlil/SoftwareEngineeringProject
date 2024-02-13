package test;

import java.util.ArrayList;

public interface Data {
    //function called dataIn that takes integers of type int and return an array of integers 
    public ArrayList<Integer> dataIn(IntegersFromTheUser numbers); 
    //boolean for now
    public boolean computationEndMessage(OutputDetails resultsDest, String results);
}