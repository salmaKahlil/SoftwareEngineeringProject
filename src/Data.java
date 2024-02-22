import java.util.ArrayList;
/*we need to implement datastore  */
public interface Data {
    ArrayList<Integer> arr(IntegersFromTheUser numbers);
    ComputeMessage computationEndMessage(OutputDetails resultDest, String results);
}  