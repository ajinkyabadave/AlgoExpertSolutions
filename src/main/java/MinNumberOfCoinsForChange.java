import java.util.*;

public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        Arrays.sort(denoms);
        List<Integer> validDenoms = new ArrayList<>();
        for(int i=0; i< denoms.length; i++){
            if(denoms[i] <= n)
                validDenoms.add(denoms[i]);
        }

        HashMap<Integer,Integer> coinMap = new HashMap<>();
        int sum = 0;
        int remainingAmount = n;
        for(int j = validDenoms.size() -1; j>=0; j--){
            coinMap = new HashMap<>();
            sum=0;
            remainingAmount = n;
            for(int i=j; i>=0; i--){
                int coin = validDenoms.get(i);
                int numOfCoins = remainingAmount / coin;
                coinMap.put(coin , numOfCoins);
                sum = sum + (coin * numOfCoins);
                remainingAmount = remainingAmount - (coin * numOfCoins);
                if(sum == n)
                    break;
            }
            if(sum == n)
                break;
        }

        int coins = 0;
        int coinDenom = 0;
        int prod =0;
        for(Map.Entry<Integer,Integer> entry: coinMap.entrySet()){
            coins = coins + entry.getValue();
            coinDenom = entry.getKey();
            prod = prod + (entry.getValue()* coinDenom);
        }
        if(prod !=n)
            return -1;
        return coins;
    }
}
