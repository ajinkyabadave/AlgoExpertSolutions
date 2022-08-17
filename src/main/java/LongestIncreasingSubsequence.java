import java.util.*;
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] sol = new int[nums.length];
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        sol[0] = 1;
        map.put(0,Collections.singletonList(sol[0]));


        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(sol[i] > 1+sol[j]){
                        map.put(i, Collections.singletonList(sol[i]));
                    }
                    else{
                        sol[i] = 1+sol[j];
                        List<Integer> subSeq = new ArrayList<>(map.get(j));
                        subSeq.add(sol[i]);
                        map.put(i,subSeq);

                    }
                }
            }
            if(sol[i] == 0){
                sol[i] = 1;
                map.put(i,Collections.singletonList(sol[i]));

            }

        }
        int max = 0;
        for(int k=0;k<sol.length;k++){
            System.out.println(nums[k]+" sol is: "+ sol[k] + " "+ map.get(k));
            if(sol[k] > max)
                max = sol[k];
        }
        return max;
    }
}
