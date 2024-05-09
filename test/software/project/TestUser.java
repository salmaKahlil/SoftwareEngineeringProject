package software.project;

import java.io.File;


public class TestUser {
	
	private final SystemCoordinator coordinator;

	public TestUser(SystemCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		String delimiter = ";";
		Integer digit = 5;
		String inputPath = "./test/software/project/testInputFile";
		IntegersFromTheUser input = new IntegersFromTheUser(inputPath);
		OutputDetails output = new OutputDetails(outputPath);
		ComputeRequest newRequest = new ComputeRequestImp(input, output, delimiter, digit);
		coordinator.runComputeEngine(newRequest);

		
	}
}


