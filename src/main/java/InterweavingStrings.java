public class InterweavingStrings {
    public static boolean interweavingStrings(String one, String two, String three) {
        return recursiveCall(one,two,three,0,0,0);
    }

    public static boolean recursiveCall(String one, String two, String three, int oneIdx, int twoIdx, int threeIdx){
        if(threeIdx == three.length())
            return true;
        boolean isTrue;
        if( oneIdx< one.length() && three.charAt(threeIdx) == one.charAt(oneIdx)){
            isTrue = recursiveCall(one,two,three,oneIdx+1,twoIdx,threeIdx+1);
            if(isTrue)
                return true;
        }
        if(twoIdx < two.length() && three.charAt(threeIdx) == two.charAt(twoIdx)){
            return recursiveCall(one,two,three,oneIdx,twoIdx+1,threeIdx+1);
        }
        return false;
    }
}
