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
        ArrayList<Integer> nums = ds.dataIn(input);
        Integer digit = nums.get(0); //Digit we search for is the first one in the array of inputs
        String result;
        for (Integer num : nums) {
             result = ce.compute(digit, num);
             output.OutputDetailsMethod(delimiter, result, String.valueOf(num));
        }
        return ComputeMessage.SUCCESS;
        
    }
}   