public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        int length = str.length();
        if(length == 2 && str.charAt(0) == str.charAt(1))
            return str;
        String maxPalindrome = "";
        String palindrome = "";

        for(int i=1; i < length-1; i++){
            if(str.charAt(i+1) == str.charAt(i) && ( (i < length - 2)
                    && str.charAt(i-1) == str.charAt(i+2))){
                palindrome = getPalindromeLength(i,str,true);
            }

            else if(str.charAt(i+1) == str.charAt(i-1)){
                palindrome = getPalindromeLength(i,str,false);
            }


            if(palindrome.length() >maxPalindrome.length() )
                maxPalindrome = palindrome;
        }

        return maxPalindrome;
    }

    public static String getPalindromeLength(int middleIndex, String str, boolean skipOneElement){
        int length = str.length();
        int left = middleIndex -1;
        int right = skipOneElement ? middleIndex + 2 : middleIndex + 1;
        String subString = "";
        while(left>=0 && right < length && str.charAt(left) == str.charAt(right)){
            subString = str.substring(left,right+1);
            left--;
            right++;
        }
        return subString;
    }
// a b a x y z z y x f
// 0 1 2 3 4 5 6 7 8 9
}
