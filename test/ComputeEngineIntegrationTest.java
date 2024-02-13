package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class ComputeEngineIntegrationTest  {
    
        
        public void TestComputeEngineIntegration()
        {
           
            //initializing the data
            int [] inputConfig={1,10,25};
            //not specifying delimter
            String delimeter=null;
          //creating instances of components
       
       ComputeEngineImp computeEngine = new ComputeEngineImp();
       DataImp dataimp= new DataImp();
       computeEngine.compute(null);
       dataimp.computationEndMessage(null, delimeter);
       IntegersFromTheUser numbers=null;
       dataimp.dataIn(numbers);
       String outputData=computeEngine.compute(null);
       assertNotNull(null);

        }

    } 

