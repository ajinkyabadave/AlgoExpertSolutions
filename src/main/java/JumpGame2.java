import java.util.Arrays;

public class JumpGame2 {
    public static int jump(int[] nums) {

        boolean hasReached = false;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        rec(0,nums,dp,0);
        return dp[nums.length-1];
    }

    public static void rec(int idx, int[] nums, int[] dp, int jumps){
        if(idx == nums.length-1){
            dp[idx] = dp[idx]!= -1 ? Math.min(dp[idx],jumps) : jumps;
            return;
        }


        if(dp[idx] != -1)
            return ;

        dp[idx] = jumps;

        int reach = nums[idx];
        while(reach !=0){
            if(idx+ reach < nums.length){
                rec(idx+reach, nums, dp, jumps+1);

            }
            reach--;
        }

    }
}
