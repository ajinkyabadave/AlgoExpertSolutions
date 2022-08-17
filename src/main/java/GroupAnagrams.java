import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str:words){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = new String(strArray);
            if(!map.containsKey(key))
                map.put(key,Arrays.asList(str));
            else{
                List<String> anagram = new ArrayList<>(map.get(key));
                anagram.add(str);
                map.put(key,anagram);
            }

        }
        for(String strKey: map.keySet())
            result.add(map.get(strKey));
        return result;

    }
}
