import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> digitMap= new HashMap<>();
        digitMap.put(2,"abc");
        digitMap.put(3,"def");
        digitMap.put(4,"ghi");
        digitMap.put(5,"jkl");
        digitMap.put(6,"mno");
        digitMap.put(7,"pqrs");
        digitMap.put(8,"tuv");
        digitMap.put(9,"wxyz");

        List<String> answer = new ArrayList<>();
        solve(0,"",answer,digits,digitMap);
        return answer;
    }
    public void solve(int index, String sol, List<String> answer, String digits,
                      HashMap<Integer,String> digitMap){
        if(index == digits.length()){
            answer.add(sol);
            return;
        }
        // character phoneNumber = digits.charAt(index);
        String letters = digitMap.get(Character.getNumericValue(digits.charAt(index)));
        char[] letterArray = letters.toCharArray();

        for(int i=0;i<letterArray.length;i++){
            solve(index+1,sol + letterArray[i],answer,digits,digitMap);
        }
    }
}
