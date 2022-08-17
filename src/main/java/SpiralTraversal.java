import java.util.*;

public class SpiralTraversal {
    public static List<Integer> spiralTraverse(int[][] array) {
        int row=0, column = 0;
        int lowerRowBoundary =0;
        int upperRowBoundary = array.length-1;
        int lowerColumnBoundary = 0;
        int upperColumnBoundary = array[0].length - 1;
        int totalElements =  array.length *  array[0].length;
        String rowStatus = "Constant";
        String columnStatus = "Increasing";
        List<Integer> sprialList = new ArrayList<>();

        for(int k=0; k< totalElements; k++){
            sprialList.add(array[row][column]);

            if(columnStatus.equals("Increasing") && (column < upperColumnBoundary)){
                column++;
                continue;
            }
            else if(columnStatus.equals("Increasing") && (column == upperColumnBoundary)){
                columnStatus = "Constant";
                rowStatus = "Increasing";
                row++;
                lowerRowBoundary++;
                continue;
            }


            if(rowStatus.equals("Increasing") && (row < upperRowBoundary)){
                row++;
                continue;
            }
            else if(rowStatus.equals("Increasing") && (row == upperRowBoundary)){
                rowStatus = "Constant";
                columnStatus = "Decreasing";
                column--;
                upperColumnBoundary--;
                continue;

            }

            if(columnStatus.equals("Decreasing") && (column > lowerColumnBoundary)){
                column--;
                continue;
            }
            else if(columnStatus.equals("Decreasing") && (column == lowerColumnBoundary)){
                columnStatus = "Constant";
                rowStatus = "Decreasing";
                row--;
                upperRowBoundary--;
                continue;
            }

            if(rowStatus.equals("Decreasing") && (row > lowerRowBoundary)){
                row--;

            }
            else if(rowStatus.equals("Decreasing")&& (row == lowerRowBoundary)) {
                rowStatus = "Constant";
                columnStatus = "Increasing";
                column++;
                lowerColumnBoundary++;
            }
        }
        return sprialList ;
    }
}
