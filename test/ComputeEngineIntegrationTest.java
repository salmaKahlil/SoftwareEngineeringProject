package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
//import org.mockito.internal.matchers.Null;

public class ComputeEngineIntegrationTest  {
    
        
        public void testComputeEngineIntegration()
        {
           
            //initializing the data
            int[] inputConfig = {1,10,25};
            //not specifying delimter
            String delimeter = null;
          //creating instances of components
       
       ComputeEngineImp computeEngine = new ComputeEngineImp();
       DataImp dataImp = new DataImp();
       computeEngine.compute(null);
       dataImp.computationEndMessage(null, delimeter);
       IntegersFromTheUser numbers = null;
       dataImp.dataIn(numbers);
       String outputData=computeEngine.compute(null);
       assertNotNull(null);

        }

    } 

