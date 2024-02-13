import java.util.ArrayList;

import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.Test;
public class TestComputeEngineImp {

    @Test
    public void testCompute() {
    ComputeEngineImp mockedEngine = mock(ComputeEngineImp.class);

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    String result = mockedEngine.compute(numbers);

    verify(mockedEngine).compute(numbers);

    assertNotNull(result);

    }

}