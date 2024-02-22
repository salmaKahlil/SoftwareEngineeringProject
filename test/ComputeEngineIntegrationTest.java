package test;

import static org.mockito.Mockito.when;

//import java.util.ArrayList;
//import java.util.List;

//import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ComputeEngineIntegrationTest  {
    @Test
        
        public void testComputeEngineIntegration()
        {
      ComputeEngineImp computeEngine = new ComputeEngineImp();
      DataImp dataImp = new DataImp();
      SystemIntegration systemInt = new SystemIntegration(dataImp, computeEngine);
      IntegersFromTheUser input = new IntegersFromTheUser(1,10,25);
      OutputDetails output = new OutputDetails();
     // ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
	 // 	when(mockRequest.getInputfromTheUser()).thenReturn(input);
		//  when(mockRequest.getOutputDetails()).thenReturn(output);
		
        }

    } 

