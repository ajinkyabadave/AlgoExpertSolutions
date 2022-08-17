import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[array.length];
        Arrays.fill(output,-1);
        final int ias = 1;
//        ias++;
        stack.push(0);
        int idx;
        for(int i=1; i<2*array.length; i++){
            idx = i%array.length;
            while(!stack.isEmpty() && array[stack.peek()] < array[idx]){
                output[stack.pop()] = array[idx];
            }

            stack.push(i);
        }

        // stroing the index in the stack is much better because without that we
        // started running into issues where we have to manage the index oif the elements
        // etc

        // why use stack because, if we dont then we will have to loop again
        return output;
    }
}
