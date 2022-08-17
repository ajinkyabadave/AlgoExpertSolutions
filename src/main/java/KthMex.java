import java.util.Arrays;

public class KthMex {
    static int kthMex(int n, int k, int arr[]) {

        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int count=0;

        int target = 0;
        while(count != k){
            int res = binSearch(arr,target);
            System.out.println("target and res k "+ target +" "+ res+ " "+count);
            if(res == -1){
                count++;
                if(count ==k)
                    return target;
            }
            target++;
        }
        return target;


    }
    public static int binSearch(int arr[], int target){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){

            int mid = (left+right)/2;

            if(arr[mid] == target)
                return arr[mid];

            if(arr[mid] > target)
                right = mid-1;

            else
                left  = mid+1;
        }
        return -1;

    }
}
