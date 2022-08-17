import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        String dir = "right"; // "left" or "right"

        int rows = matrix.length;
        int cols = matrix[0].length;

        int lowerColLimit = 0;
        int upperColLimit = cols-1;

        int lowerRowLimit = 0;
        int upperRowLimit = rows-1;

        int row=0;
        int col =0;
        int k=0;
        while(k<rows*cols){
            if(dir.equals("right")){
                for(int i=lowerColLimit; i<=upperColLimit; i++){
                    output.add(matrix[row][i]);
                    k++;
                }
                dir = "down";
                col = upperColLimit;
                lowerRowLimit++;
                continue;
            }

            if(dir.equals("down")){
                for(int i=lowerRowLimit; i<=upperRowLimit; i++){
                    output.add(matrix[i][col]);
                    k++;
                }

                dir = "left";
                row = upperRowLimit;
                upperColLimit--;
                continue;
            }

            if(dir.equals("left")){
                for(int i=upperColLimit; i>=lowerColLimit; i--){
                    output.add(matrix[row][i]);
                    k++;
                }

                dir = "up";
                col = lowerColLimit;
                upperRowLimit--;
                continue;
            }

            if(dir.equals("up")){
                for(int i=upperRowLimit; i>=lowerRowLimit; i--){
                    output.add(matrix[i][col]);
                    k++;
                }

                dir = "right";
                row = lowerRowLimit;
                lowerColLimit++;
                continue;
            }
        }

        return output;

    }
}
