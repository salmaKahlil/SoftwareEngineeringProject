import org.junit.Assert;
import org.junit.Test;


public class ComputeEngineTest {

    @Test
    public void testCompute() {
        ComputeEngine engine = new ComputeEngineImp(); 
		Assert.assertEquals("13", engine.compute(1, 25));

    }

}