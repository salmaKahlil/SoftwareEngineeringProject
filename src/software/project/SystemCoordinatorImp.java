package software.project;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;



public class SystemCoordinatorImp implements SystemCoordinator {

    private final Data ds;
    private final ComputeEngine ce;
    
    public SystemCoordinatorImp(Data ds, ComputeEngine ce) {
        this.ds = ds;
        this.ce = ce;
    }

    @Override
    public ComputeMessage runComputeEngine(ComputeRequest request){
    
        IntegersFromTheUser input = request.getInputConfig();
        OutputDetails output = request.getOutputConfig(); 
        String delimiter = request.getDelimeter(); 
        //ArrayList<Integer> nums = ds.dataIn(input);
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> inputNums = new ArrayList<>();
        inputNums = ds.dataIn(input);
        nums.addAll(inputNums);
        Integer digit = request.getDigit();


        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Integer num : nums) {
            Callable<String> computation = () -> {
                String result = ce.compute(digit, num);
                return result;
            };

            Future<String> future = executor.submit(computation);
            try {
                String result = future.get();
                output.outputDetailsMethod(delimiter, result, String.valueOf(num));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return ComputeMessage.SUCCESS;
        
    }
}   