import java.util.HashMap;

public class TwoNumberSum {
    public  int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer,Integer> arrayMap = new HashMap<>();
        for(int i: array){
            arrayMap.put(targetSum-i, i);
        }

        int[] solution = new int[2];
        int k=0;
        for(int element: array)
        {
            if(arrayMap.get(element)!=null && arrayMap.get(element)!=element){
                solution[k] = arrayMap.get(element);
                solution[++k] = targetSum - arrayMap.get(element);
                return solution;
            }
        };
        return new int[0];
    }
}
