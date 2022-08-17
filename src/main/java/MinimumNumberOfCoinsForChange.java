import java.util.Arrays;

public class MinimumNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] denomArray = new int[n+1];
        Arrays.fill(denomArray,Integer.MAX_VALUE);
        Arrays.sort(denoms);
        denomArray[0] = 0;

        for(int i=0; i< denoms.length; i++){
            for(int j=1; j< n+1; j++){
                if(denoms[i] > j) continue;
                denomArray[j] = Math.min(denomArray[j], 1 + denomArray[j-denoms[i]]);
            }
        }

        return denomArray[n];
    }
}
