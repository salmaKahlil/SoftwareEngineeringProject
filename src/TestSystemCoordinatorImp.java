
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.Test;
public class TestSystemCoordinatorImp {
    @Test
    public void testRunComputeEngine() {
      
        SystemCoordinatorImp mockedCoordinator = mock(SystemCoordinatorImp.class);

        ComputeRequest inputRequest = new ComputeRequest();

        ComputeMessage result = mockedCoordinator.runComputeEngine(inputRequest);

        verify(mockedCoordinator).runComputeEngine(inputRequest);

        assertNotNull(result);

        
    }
}
