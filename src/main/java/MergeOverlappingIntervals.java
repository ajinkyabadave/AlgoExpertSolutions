import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int rows = intervals.length;
        int[][] mergedArray = new int[rows][2];
//         Arrays.sort(intervals);
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        mergedArray[0] = intervals[0];
        int mIdx = 0;
        int iIdx = 1;

        for(int i=1; i< rows; i++){
            if(mergedArray[mIdx][1] >= intervals[iIdx][0]){
                mergedArray[mIdx][1] = Math.max(intervals[iIdx][1],mergedArray[mIdx][1] );
                iIdx++;
            }
            else{
                mIdx++;
                mergedArray[mIdx] = intervals[iIdx];
                iIdx++;
            }
        }

        int [][] finalOutput = new int[mIdx+1][2];
        for(int k=0; k<= mIdx;k++){
            finalOutput[k] = mergedArray[k];
        }

        return finalOutput;
    }
}
