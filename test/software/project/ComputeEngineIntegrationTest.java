package software.project;

import static org.mockito.Mockito.when;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeWorkflow() {
        ComputeEngine engine = new ComputeEngineImp();
        Data testDs = new DataImp();
        SystemCoordinator coordinator = new SystemCoordinatorImp(testDs, engine);
        IntegersFromTheUser input = new IntegersFromTheUser("");
        OutputDetails output = new OutputDetails("");
       

        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        
        when(mockRequest.getInputConfig()).thenReturn(input);
        when(mockRequest.getOutputConfig()).thenReturn(output);
        when(mockRequest.getDelimeter()).thenReturn(";");

        ComputeMessage result = coordinator.runComputeEngine(mockRequest);

        Assert.assertEquals(ComputeMessage.SUCCESS, result);


    }
}