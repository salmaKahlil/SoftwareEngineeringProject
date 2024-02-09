import java.util.ArrayList;

public interface Data{
    ArrayList<Integer> arr(IntegersFromTheUser numbers);
    ComputeMessage computationEndMessage(OutputDetails resultDest, String results);
}