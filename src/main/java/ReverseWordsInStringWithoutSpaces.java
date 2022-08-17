import java.util.Arrays;

public class ReverseWordsInStringWithoutSpaces {
    public static String reverseWords(String s) {
        char[] stringArray = s.toCharArray();
        stringArray = trim(stringArray,0,s.length()-1);
        swap(stringArray,0,stringArray.length-1);
        int start =0;
        int end = 0;

//         boolean hasWordStarted = false;
//         StringBuilder reversedStringBuilder = new StringBuilder();
//         for(int i=stringArray.length-1; i>= 0; i--){
//             if(stringArray[i] == ' '){
//                 if(hasWordStarted){
//                     reversedStringBuilder.append(stringArray[i]);  // word was ongoing and we get space, i.e.
//                     hasWordStarted = false;     // first space hence we add and now set
//                     // has word starte d= false
//                 }
//             }
//             else{
//                 if(!hasWordStarted)
//                     hasWordStarted = true;
//                reversedStringBuilder.append(stringArray[i]);
//             }
//         }

//         System.out.println(reversedStringBuilder);
//         stringArray = reversedStringBuilder.toString().toCharArray();
        while(end< stringArray.length){
            if(stringArray[end] != ' ')
                end++;


            else if(stringArray[start] != ' '){
                swap(stringArray,start,end-1);
                start = end;
            }
            else {
                start++;
                end++;
            }
        }
        swap(stringArray,start,end-1);

        for(int i =0; i<stringArray.length; i++){
            System.out.println(" i:" + stringArray[i]);
        }
        return new String(stringArray)  ;
    }

    public static void swap(char[] stringArray, int startIdx, int endIdx){
        while(startIdx < endIdx){
            char temp = stringArray[startIdx];
            stringArray[startIdx] = stringArray[endIdx];
            stringArray[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }

    public static char[] trim(char[] stringArray, int startIdx, int endIdx){
        // removed trailing spaces

        while(stringArray[startIdx] == ' '){
            startIdx++;
        }
        while(stringArray[endIdx] == ' '){
            endIdx--;
        }


        boolean hasWordStarted = false;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = startIdx; i<= endIdx; i++){
            if(stringArray[i] == ' '){
                if(hasWordStarted){
                    stringBuilder.append(stringArray[i]);
                    hasWordStarted = false;
                }
            }
            else{
                if(!hasWordStarted)
                    hasWordStarted = true;
                stringBuilder.append(stringArray[i]);
            }
        }

        return stringBuilder.toString().toCharArray();
    }

}
