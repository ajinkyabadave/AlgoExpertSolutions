public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.
        double highestPeak = Double.NEGATIVE_INFINITY;
        int highestPeakLength=0;
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        int currentPeakLength = 0;
        double currentPeak = Double.NEGATIVE_INFINITY;

        for(int i=0; i< array.length -1; i++){
            if(array[i+1] > array[i]){
                currentPeakLength++;

                if(isDecreasing){
                    isDecreasing = false;
//                    currentPeak = (double) array[i];
                    if(highestPeak < currentPeak){
                        highestPeak = currentPeak;
                        highestPeakLength = currentPeakLength;
                    }
                    currentPeakLength = 0;
                }
                else{
                    isIncreasing = true;
                    currentPeak = (double) array[i+1];
                }
            }
            else if(array[i+1] == array[i]){
                isIncreasing = false;
                currentPeakLength = 0;
            }
            else{
                isDecreasing = true;
                currentPeakLength++;
                if(isIncreasing){
                    isIncreasing = false;
                    if (i== array.length - 2){
                        currentPeakLength = currentPeakLength + 2;
                    } else{
                        currentPeakLength = currentPeakLength + 1;
                    }
                    if(highestPeak < currentPeak){
                        highestPeak = currentPeak;
                        highestPeakLength = currentPeakLength;
                    }
                }

            }
        }

        return highestPeakLength;
    }
}
