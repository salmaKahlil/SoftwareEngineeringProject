package software.project;
import java.util.ArrayList;

public class DataImp implements Data{

    @Override
    public ArrayList<Integer>  dataIn(IntegersFromTheUser numbers) {
       return numbers.getIntegersFromTheUser();
    }

    @Override
    public ComputeMessage computationEndMessage(OutputDetails resultDest,  String input, String results ){
        resultDest.outputDetailsMethod(results, input, results);
        return ComputeMessage.SUCCESS;
    }
}