package test;

import java.util.ArrayList;

public class SystemIntegration {
//INPUT OUTPUT DATA COMPUTE ENGINE 
    
    IntegersFromTheUser inputStreamFromUser = new IntegersFromTheUser();
    OutputDetails outputDetails = new OutputDetails();

    DataImp dataImp = new DataImp();
    ComputeEngineImp computeEngine = new ComputeEngineImp();

    // Run integration
    ArrayList<Integer> processedInput = dataImp.dataIn(inputStreamFromUser);
    String computedOutput = computeEngine.compute(processedInput);
    boolean computationResult = dataImp.computationEndMessage(outputDetails, computedOutput);
    
    


}
