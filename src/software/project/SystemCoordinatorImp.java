package software.project;

import java.util.ArrayList;

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
        Integer digit; 
        if (!nums.isEmpty()) {
            digit = nums.get(0);
        } else {

            digit = 0;

        }
        String result;
        for (Integer num : nums) {
            result = ce.compute(digit, num);
            output.outputDetailsMethod(delimiter, result, String.valueOf(num));
        }
        return ComputeMessage.SUCCESS;
        
    }
}   