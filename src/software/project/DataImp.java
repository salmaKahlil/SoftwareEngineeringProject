import java.util.Collections;

public class DataImp implements Data{

    @Override
    public Iterable<Integer>  dataIn(IntegersFromTheUser numbers) {

        return Collections.emptyList();
    }

    @Override
    public ComputeMessage computationEndMessage(OutputDetails resultDest, String results){
        
        return ComputeMessage.FAILURE;
    }
}