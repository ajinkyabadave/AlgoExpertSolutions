import java.util.List;
import java.util.Objects;

public class ValidateSubSequence {
    public  boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int sequenceLength = sequence.size();
        int arrayLength = array.size();
        boolean hasMatched;
        int k=0;

        for (Integer integer : array) {

            if (Objects.equals(integer, sequence.get(k))) {
                k++;
            }
            if (k == sequenceLength)
                return true;

        }
        return false;
    }

}
