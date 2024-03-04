package software.project;
import java.io.File;


public class TestUser {
	
	private final SystemCoordinator coordinator;

	public TestUser(SystemCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
	}

}
