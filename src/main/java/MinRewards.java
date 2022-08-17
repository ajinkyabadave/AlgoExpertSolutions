import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards,1);

        for(int i=1; i < scores.length; i++){
            if(scores[i] > scores[i-1]){
                rewards[i] = rewards[i-1] +1;
            }
        }

        for(int i=scores.length-2 ; i >= scores.length; i--){
            if(scores[i] > scores[i+1]){
                rewards[i] = Math.max(rewards[i+1] +1,rewards[i]);
            }
        }
        return Arrays.stream(rewards).sum();
    }
}
