import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DataTest {
    
    @Test
	public void testDataIn() {
		IntegersFromTheUser inputConfig = Mockito.mock(IntegersFromTheUser.class);
		Data data = new DataImp();
		Assert.assertEquals(3, data.dataIn(inputConfig));
	}

    @Test
	public void testComputationEndMessage() {
		OutputDetails outputDetailsTest = Mockito.mock(OutputDetails.class);
		String results = "";
		Data data = new DataImp();

		Assert.assertEquals(ComputeMessage.SUCCESS, data.computationEndMessage(outputDetailsTest, results));
	}
}