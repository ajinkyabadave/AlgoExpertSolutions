import java.util.*;

public class PowerSet {
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powerList = new ArrayList<>();
        powerList.add(new ArrayList<>());

        String asd = "algoexpet is the best";
        asd.substring(0,3);
        char[] as1 = {'a','b','c'};
        as1.toString();

        for(int i=0; i<array.size();i++){
            int size = powerList.size();
            for(int j=0; j<size;j++){
                List<Integer> subSet = new ArrayList<>(powerList.get(j));
                subSet.add(array.get(i));
                powerList.add(subSet);
            }
        }

        return powerList;
    }
}
