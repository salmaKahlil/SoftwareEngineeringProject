package test;

import java.util.ArrayList;

public class IntegersFromTheUser {
        private ArrayList<Integer> inputConfig = new ArrayList<Integer>();

    void setIntegersFromTheUser(ArrayList<Integer> p){
        //from the compute engine
        inputConfig = p;

    }
    ArrayList<Integer> getIntegersFromTheUser(){   
        return inputConfig;

    }
}
