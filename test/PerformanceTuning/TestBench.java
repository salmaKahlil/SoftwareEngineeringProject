package PerformanceTuning;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import software.project.ComputeEngineImp;
import software.project.NewComputeEngineImp;

public class TestBench {
    @Test
    public void testComputation() {
        NewComputeEngineImp fasterImp = new NewComputeEngineImp();
        long startTime = System.nanoTime();
        int NUM_RUNS = 100;
        for (int i = 0; i < NUM_RUNS; i++) {
            fasterImp.compute(5,5555500);
        }
        long endTime = System.nanoTime();
        long elapsedTimeFasterImp = (endTime - startTime)/ NUM_RUNS;
        System.out.println("Faster Elapsed time: " + elapsedTimeFasterImp + " ns");

        ComputeEngineImp slowImp = new ComputeEngineImp();

        startTime = System.nanoTime();
        for (int i = 0; i < NUM_RUNS; i++) {
            slowImp.compute(5,5555500);
        }
        endTime = System.nanoTime();
        long elapsedTimeSlowImp = (endTime - startTime)/ NUM_RUNS;
        System.out.println("Original Elapsed time: " + elapsedTimeSlowImp + " ns");

        long impPercentage = elapsedTimeSlowImp / elapsedTimeFasterImp;
        System.out.println("Measure of improvement : " + impPercentage + " %");

        if((elapsedTimeFasterImp - elapsedTimeSlowImp) > -1*elapsedTimeSlowImp*0.1) {
            Assertions.fail();
        }
    }

}

