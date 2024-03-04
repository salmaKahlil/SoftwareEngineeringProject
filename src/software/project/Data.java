package software.project;
import java.util.ArrayList;
public interface Data {

    ArrayList<Integer> dataIn(IntegersFromTheUser numbers);
    ComputeMessage computationEndMessage(OutputDetails resultDest, String input, String results);
}