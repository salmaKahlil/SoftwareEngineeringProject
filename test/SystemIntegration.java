package test;

import java.util.ArrayList;

public class SystemIntegration {
//INPUT OUTPUT DATA COMPUTE ENGINE 
    
    public SystemIntegration(DataImp dataImp2, ComputeEngineImp computeEngine2) {
        //TODO Auto-generated constructor stub
    }
    IntegersFromTheUser inputStreamFromUser = new IntegersFromTheUser(0, 0, 0);
    OutputDetails outputDetails = new OutputDetails();

    DataImp dataImp = new DataImp();
    ComputeEngineImp computeEngine = new ComputeEngineImp();

    // Run integration
    ArrayList<Integer> processedInput = dataImp.dataIn(inputStreamFromUser);
    String computedOutput = computeEngine.compute(processedInput);
    boolean computationResult = dataImp.computationEndMessage(outputDetails, computedOutput);
    
    


}
