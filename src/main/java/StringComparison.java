public class StringComparison {

    public static Boolean isSubString(String str1, String str2){
        // str1 = Cafifornia
        // str2 = for

        int str1Length = str1.length();
        int str2Length = str2.length();

        int idx1 = 0;
        int idx2 = 0;
        boolean comparisonStarted = false;

        while(idx2!= str2Length-1 || idx1 != str1Length-1){
            if(str1.charAt(idx1) == str2.charAt(idx2)){
                if(!comparisonStarted)
                    comparisonStarted = true;

                idx2++;

                if(idx2 == str2Length)
                    return true;
            }
            else{
                if(comparisonStarted){
                    comparisonStarted = false;
                    idx2 = 0;
                }

            }

            idx1++;
        }
        return false;
    }

}
