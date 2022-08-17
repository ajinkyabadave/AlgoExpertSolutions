import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        int rows =str1.length()+1;
        int cols = str2.length()+1;
        String[][] dp = new String[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(i == 0 || j==0){
                    dp[i][j] = "";
                    continue;
                }

                String dpValue = "";
                // i and j are ahead by 1
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dpValue = dp[i-1][j-1] + str1.charAt(i-1);
                }
                else{
                    String option1 = dp[i-1][j];
                    String option2 = dp[i][j-1];

                    if(option1.length() > option2.length())
                        dpValue = option1;
                    else
                        dpValue = option2;
                }



                dp[i][j] = dpValue;

            }
        }

        String sol = dp[rows-1][cols-1];
        List<Character> solution = new ArrayList<>();
        for(int k=0; k<sol.length();k++){
            solution.add(sol.charAt(k));
        }
        return solution;
    }
}
