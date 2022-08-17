public class FindTheDuplicateNumber {
    //Binary search method
//    public static int findDuplicate_bs(int[] nums) {
//        int len = nums.length;
//        int low = 1;
//        int high = len - 1;
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            int cnt = 0;
//            for (int i = 0; i < len; i++) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//
//            if (cnt <= mid) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//
//        return low;
//    }


    // loop method
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        while(fast!=slow);

        slow =0;

        while(fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[slow];
    }
}
