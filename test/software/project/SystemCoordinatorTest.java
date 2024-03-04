package software.project;
import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class SystemCoordinatorTest {

    @Test   
    public void testRunComputeEngine() {
        Data dataTest = Mockito.mock(Data.class);
		ComputeEngine computeEngineTest = Mockito.mock(ComputeEngine.class);

        SystemCoordinator coordinator = new SystemCoordinatorImp(dataTest, computeEngineTest);

        ComputeRequest requestTest = Mockito.mock(ComputeRequest.class);
        IntegersFromTheUser inputConfig = new IntegersFromTheUser("C:\\Users\\AUC\\OneDrive\\Documents\\GitHub\\SoftwareEngineeringProject\\src\\software\\project\\test.txt");
        OutputDetails outputConfig = new OutputDetails("C:\\Users\\AUC\\OneDrive\\Documents\\GitHub\\SoftwareEngineeringProject\\src\\software\\project\\test.txt");
        requestTest = new ComputeRequestImp(inputConfig, outputConfig, ";");

        ComputeMessage result = coordinator.runComputeEngine(requestTest);


        Assert.assertEquals(ComputeMessage.SUCCESS, result);
    }
}