package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ComputeEngineIntegrationTest  {
    {
        @Test
        public void TestComputeEngineIntegration()
        {
           
            //initializing the data
            int [] inputConfig={1,10,25};
            //not specifying delimter
            String delimeter=null;
          //creating instances of components
       
       ComputeEngineImp computeengine = new ComputeEngineImp();
       DataImp     dataimp= new DataImp();
       computeengine.compute(null);
       dataimp.computationEndMessage(null, delimeter);
    IntegersFromTheUser numbers;
     dataimp.dataIn(numbers);
     String outputString=computeengine.compute(null);
      assertNotNull(null);

        }

        
}
