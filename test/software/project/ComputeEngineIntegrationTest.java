package software.project;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;



public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeWorkflow() {
        ComputeEngine engine = new ComputeEngineImp();
        Data testDs = new DataImp();
        SystemCoordinator coordinator = new SystemCoordinatorImp(testDs, engine);
        IntegersFromTheUser input = new IntegersFromTheUser("./src/software/project/test.txt");
        OutputDetails output = new OutputDetails("IntegrationTestOuput");
        Integer digit = 5;


        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        
        when(mockRequest.getInputConfig()).thenReturn(input);
        when(mockRequest.getOutputConfig()).thenReturn(output);
        when(mockRequest.getDelimeter()).thenReturn(";");
        when(mockRequest.getDigit()).thenReturn(5);

        ComputeMessage result = coordinator.runComputeEngine(mockRequest);

        Assert.assertEquals(ComputeMessage.SUCCESS, result);


    }
}