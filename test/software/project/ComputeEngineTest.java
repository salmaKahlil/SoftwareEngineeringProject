package software.project;


import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ComputeEngineTest {

    @Test
    public void testCompute() {
        NewComputeEngineImp engine = new NewComputeEngineImp();
		Assert.assertEquals("27780", engine.compute(5, 55555  ));

    }

}