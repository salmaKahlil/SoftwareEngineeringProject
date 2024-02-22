package test;

import java.util.ArrayList;

public class IntegersFromTheUser {
        private ArrayList<Integer> inputConfig = new ArrayList<Integer>();

    public IntegersFromTheUser(int i, int j, int k) {
            //TODO Auto-generated constructor stub
        }
    void setIntegersFromTheUser(ArrayList<Integer> p){
        //from the compute engine
        inputConfig = p;

    }
    ArrayList<Integer> getIntegersFromTheUser(){   
        return inputConfig;

    }
}
