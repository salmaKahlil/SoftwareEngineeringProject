package software.project;

public class ComputeRequestImp implements ComputeRequest {

    private IntegersFromTheUser inputConfig;
    private OutputDetails outputConfig;
    private String delimiter;
    private Integer digit;


    // Constructor to initialize the ComputeRequest with user specifications
    public ComputeRequestImp(IntegersFromTheUser inputConfig, OutputDetails outputConfig, String delimiter, Integer digit) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
        this.delimiter = delimiter;
        this.digit = digit;
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

    public Integer getDigit() {
        return digit;
    }
    
}
