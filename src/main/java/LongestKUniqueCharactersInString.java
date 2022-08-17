import java.util.HashMap;

public class LongestKUniqueCharactersInString {
    public static int longestkSubstr(String s, int k) {
        // code here

        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end< s.length()){

            char curr = s.charAt(end);
            System.out.println("insert: "+ curr + " "+ start + " "+ end);
            int currCount = map.getOrDefault(curr,0) +1;
            map.put(curr,currCount);

            while(map.size() > k){

                char removeChar = s.charAt(start);
                System.out.println("remove: "+removeChar+ " "+ start + " "+ end);
                int removeCount = map.get(removeChar)-1;
                if(removeCount ==0)
                    map.remove(removeChar);
                else
                    map.put(removeChar,removeCount);
                start++;
            }
            if(end-start+1 > maxLen)
                maxLen = end-start+1;

            end++;
        }

        return maxLen;
    }
}
