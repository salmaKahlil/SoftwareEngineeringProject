

public class SystemCoordinatorImp implements SystemCoordinator {

    private final Data ds;
	private final ComputeEngine ce;
	
	public SystemCoordinatorImp(Data ds, ComputeEngine ce) {
		this.ds = ds;
		this.ce = ce;
	}
   
    @Override
    public ComputeMessage runComputeEngine(ComputeRequest request){
        return ComputeMessage.FAILURE;
    }
}