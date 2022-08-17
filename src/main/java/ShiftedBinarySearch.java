public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<array.length; i++){
            if(array[i]< min){
                min = array[i];
                minIndex = i;
            }
        }

        int i = 0;
        int j = array.length -1;


        int iWithIndex = (i+minIndex)%array.length;
        int jWithIndex = (j+minIndex)%array.length;
        while(i < j){

            int midWithIndex = (((i+j)/2) + minIndex)%array.length;
            int mid = (i+j)/2;

            if(array[midWithIndex] < target){
                j  = mid-1;
                jWithIndex = midWithIndex -1;
            }
            else if(array[midWithIndex] > target){
                i = mid+1;
                iWithIndex = midWithIndex+1;
            }
            else
                return mid;
        }

        return -1;
    }
}
