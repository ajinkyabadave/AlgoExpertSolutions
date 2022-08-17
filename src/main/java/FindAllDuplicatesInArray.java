import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int i=0;i<nums.length; i++){
            int idx = nums[i];

            if(idx < 0){
                duplicates.add(i);
            }
            else{
                nums[idx] = nums[idx] * (-1);
            }
        }


        return duplicates;
    }
}
