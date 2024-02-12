package test;

import java.util.ArrayList;

public class IntegrationTest implements Data {
        //function called dataIn that takes integers of type int and return an array of integers 
    public ArrayList<Integer> dataIn(IntegersFromTheUser numbers){
        ArrayList<Integer> p = new ArrayList<Integer>();
        p = numbers.getIntegersFromTheUser();
        return p;
    } 
    public ArrayList<String> computationEndMessage(OutputDetails results){
        ArrayList<String> p = new ArrayList<String>();
        p = results.getOutputDetails();
        return p;
    }
}
