package performanceTuning;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import software.project.ComputeEngineImp;
import software.project.NewComputeEngineImp;

public class TestBench {
    @Test
    public void testComputation() {
        NewComputeEngineImp fasterImp = new NewComputeEngineImp();
        int numRuns = 100;
        long startTime = System.nanoTime();

        for (int i = 0; i < numRuns; i++) {
            fasterImp.compute(5,5555500);
        }
        long endTime = System.nanoTime();
        long elapsedTimeFasterImp = (endTime - startTime)/ numRuns;
        System.out.println("Faster Elapsed time: " + elapsedTimeFasterImp + " ns");

        ComputeEngineImp slowImp = new ComputeEngineImp();

        startTime = System.nanoTime();
        for (int i = 0; i < numRuns; i++) {
            slowImp.compute(5,5555500);
        }
        endTime = System.nanoTime();
        long elapsedTimeSlowImp = (endTime - startTime)/ numRuns;
        System.out.println("Original Elapsed time: " + elapsedTimeSlowImp + " ns");

        long impPercentage = elapsedTimeSlowImp / elapsedTimeFasterImp;
        System.out.println("Measure of improvement : " + impPercentage + " %");

        if((elapsedTimeFasterImp - elapsedTimeSlowImp) > -1*elapsedTimeSlowImp*0.1) {
            Assertions.fail();
        }
    }

}

