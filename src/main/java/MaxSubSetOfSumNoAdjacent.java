public class MaxSubSetOfSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int sum1=0;int sum2=0;
        for(int i=0; i<array.length; i = i+2){
            sum1 = sum1 + array[i];
        }

        for(int i=1; i<array.length; i = i+2){
            sum2 = sum2 + array[i];
        }
        if(sum1 > sum2)
            return sum1;

        return sum2;
    }
}
