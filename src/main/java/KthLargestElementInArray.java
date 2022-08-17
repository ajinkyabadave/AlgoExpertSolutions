import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthLargestElementInArray {
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            priorityQueue.add(nums[i]);
            if(i+1 == nums.length -k) {
                return priorityQueue.peek();
            }
        }
        return k;
    }
}
