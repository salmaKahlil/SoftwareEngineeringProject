import java.util.ArrayList;

import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
public class TestComputeEngineImp {

    @Test
    public void smokeTestCompute()
    {
        ComputeEngine engine = new ComputeEngineImp();
        Assert.assertEquals("1", engine.compute(null));
    }

    }

