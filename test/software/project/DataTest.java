import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DataTest {
    
    @Test
	public void testDataIn() {
		IntegersFromTheUser inputConfig = Mockito.mock(IntegersFromTheUser.class);
		inputConfig =  new IntegersFromTheUser("test.txt");
		ArrayList<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		Data data = new DataImp();
		Assert.assertEquals(test, data.dataIn(inputConfig));
	}

    // @Test
	// public void testComputationEndMessage() {
	// 	OutputDetails outputDetailsTest = Mockito.mock(OutputDetails.class);
	// 	String results = "";
	// 	Data data = new DataImp();

	// 	Assert.assertEquals(ComputeMessage.SUCCESS, data.computationEndMessage(outputDetailsTest, results));
	// }
}