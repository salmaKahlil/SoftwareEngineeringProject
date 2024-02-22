

public interface Data {

    Iterable<Integer> dataIn(IntegersFromTheUser numbers);
    ComputeMessage computationEndMessage(OutputDetails resultDest, String results);
}