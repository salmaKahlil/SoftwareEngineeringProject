import org.mockito.Mock;
import org.mockito.Mockito;

import test.DataImp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;

public class TestDataImplementation {
    @Test
    public void testData() {
       

 //input data
 IntegersFromTheUser mocknum = Mockito.mock(IntegersFromTheUser.class);
 Mockito.when(mocknum.getIntegersFromTheUser());

DataImp dataImp = new DataImp();
ArrayList<Integer> result = dataImp.dataIn(mocknum);
assertEquals(dataImp, result);



}
@Test
    public void testcomputationEndMessage(){
        OutputDetails mockOutputDetails = Mockito.mock(OutputDetails.class);
        DataImp dataImp = new DataImp();
        boolean success = dataImp.computationEndMessage(mockOutputDetails, null);
        assertEquals(true,success);

}
}
