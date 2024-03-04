package software.project;


public class ComputeRequestImp implements ComputeRequest {

    private IntegersFromTheUser inputConfig;
    private OutputDetails outputConfig;
    private String delimiter;

    // Constructor to initialize the ComputeRequest with user specifications
    public ComputeRequestImp(IntegersFromTheUser inputConfig, OutputDetails outputConfig, String delimiter) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
        this.delimiter = delimiter;
    }

    @Override
    public IntegersFromTheUser getInputConfig() {
        return inputConfig;
    }

    @Override
    public OutputDetails getOutputConfig() {
        return outputConfig;
    }

    @Override
    public String getDelimeter() {
        return delimiter;
    }
    
}
