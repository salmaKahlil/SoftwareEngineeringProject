package software.project;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.Assert;


public class SystemCoordinatorTest {

    @Test
    public void testRunComputeEngine() {
        Data dataTest = Mockito.mock(Data.class);
		ComputeEngine computeEngineTest = Mockito.mock(ComputeEngine.class);

        SystemCoordinator coordinator = new SystemCoordinatorImp(dataTest, computeEngineTest);

        ComputeRequest requestTest = Mockito.mock(ComputeRequest.class);
        IntegersFromTheUser inputConfig = new IntegersFromTheUser("./src/software/project/test.txt");
        OutputDetails outputConfig = new OutputDetails("SystemCoordinatorTestOuput");

        requestTest = new ComputeRequestImp(inputConfig, outputConfig, ";", 5);

        ComputeMessage result = coordinator.runComputeEngine(requestTest);


        Assert.assertEquals(ComputeMessage.SUCCESS, result);
    }
}