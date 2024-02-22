import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

public class SystemCoordinatorTest {
    @Test   
    public void TestRunComputeEngine() {
        Data dataTest = Mockito.mock(Data.class);
		ComputeEngine computeEngineTest = Mockito.mock(ComputeEngine.class);

        SystemCoordinator coordinator = new SystemCoordinatorImp(dataTest, computeEngineTest);

        ComputeRequest requestTest = Mockito.mock(ComputeRequest.class);
        ComputeMessage result = coordinator.runComputeEngine(requestTest);


        Assert.assertEquals(result, ComputeMessage.SUCCESS);
    }
}
