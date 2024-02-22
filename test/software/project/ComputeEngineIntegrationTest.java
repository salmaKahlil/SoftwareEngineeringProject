import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeWorkflow() {
        ComputeEngine engine = new ComputeEngineImp();
        NewData testDs = new NewData();
        SystemCoordinator coordinator = new SystemCoordinatorImp(testDs, engine);
        InputForTest input = new InputForTest(1, 10, 25);
        OutputDetailsForTest output = new OutputDetailsForTest();
        ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
        when(mockRequest.getInputConfig()).thenReturn(input);
        when(mockRequest.getOutputConfig()).thenReturn(output);
        ComputeMessage result = coordinator.runComputeEngine(mockRequest);
        Assert.assertEquals(ComputeMessage.SUCCESS, result);
        ArrayList<String> expected = new ArrayList<>();
		expected.add("1");
		expected.add("10");
		expected.add("25");
       
        Assert.assertEquals(expected, output.getOutputDetails());

    }
}
