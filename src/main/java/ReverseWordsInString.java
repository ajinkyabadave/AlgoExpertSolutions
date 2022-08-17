import java.util.Arrays;
import java.util.Stack;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char[] stringArray = s.toCharArray();

        stringArray = reverse(stringArray,0,s.length()-1);

        int start =0;
        int end = 0;
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

    public static char[] reverse(char[] stringArray, int startIdx, int endIdx){
        while(stringArray[startIdx] == ' '){
            startIdx++;
        }
        while(stringArray[endIdx] == ' '){
            endIdx--;
        }
        char[] stringWOSpaces = Arrays.copyOfRange(stringArray,startIdx,endIdx+1);

        swap(stringWOSpaces,0,stringWOSpaces.length-1);
        return stringWOSpaces;
    }
//    public static String reverseWordsInString(String string) {
//        char[] strArr = string.toCharArray();
//
//        reverseArr(strArr, 0, string.length()-1);
//
//        for(int i=0; i<strArr.length; i++){
//            System.out.println(strArr[i]);
//        }
//
//        int start=0;
//        int end=0;
//
//        while(end< string.length()){
//            if(strArr[end]!=' ')
//                end++;
//            else if(strArr[start] !=' '){
//                reverseArr(strArr,start,end-1);
//                start = end;
//            }
//            else{
//                start++;
//                end++;
//            }
//        }
//        reverseArr(strArr,start,end-1);
//        return new String(strArr);
//    }
//
//    public static void reverseArr(char[] array, int start, int end){
//        while(start<end){
//            char temp = array[end];
//            array[end] = array[start];
//            array[start] = temp;
//            start++;
//            end--;
//        }
//    }
}
