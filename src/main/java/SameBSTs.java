import java.util.ArrayList;
import java.util.List;

public class SameBSTs {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size() != arrayTwo.size())
            return false;
        if(arrayOne.get(0) != arrayTwo.get(0))
            return false;

        int size = arrayOne.size();
        int rootNode = arrayOne.get(0);

        List<Integer> greaterElements = new ArrayList<>();
        List<Integer> smallerElements = new ArrayList<>();

        for(int i=1;i<size;i++){
            int element =arrayOne.get(i);
            if(element > rootNode)
                greaterElements.add(element);
            else
                smallerElements.add(element);
        }

        int greaterEleIdx = 0;
        int smallerEleIdx = 0;

        for(int i=1;i<size;i++){
            int element =arrayOne.get(i);
            if(element > rootNode && element != greaterElements.get(greaterEleIdx))
                return false;

            else
            if(element < rootNode && element != smallerElements.get(smallerEleIdx))
                return false;
        }

        return true;
    }
}
