package test;

import java.util.ArrayList;

public class DataImp implements Data {
    public DataImp(){

    }

    //function called dataIn that takes integers of type int and return an array of integers 
    public ArrayList<Integer> dataIn(IntegersFromTheUser numbers){
        ArrayList<Integer> p = new ArrayList<Integer>();
        p = numbers.getIntegersFromTheUser();
        return p;
    } 


    public boolean computationEndMessage(OutputDetails resultsDest, String results){
        
        ArrayList<String> p = new ArrayList<String>();
        p = resultsDest.getOutputDetails();
        p.add(results);
        return true;
        
    }
}
