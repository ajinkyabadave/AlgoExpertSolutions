import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[][] visited = new int[rows][cols];
        int riverSize=1;
        List<Integer> riverSizes = new ArrayList<>();


        for(int i=0; i<rows; i++){
            for(int j=0; j <cols; j++){
                if(visited[i][j] == 1)
                    continue;
//                else visited[i][j] = 1;

                if(matrix[i][j] == 1){
                    riverSize = 1;
                    riverSize = traverse(matrix, i, j, riverSize, rows,cols,visited);
                    riverSizes.add(riverSize);
                }


            }
        }
        return riverSizes;
    }

    public static int traverse(int[][] matrix, int i, int j, int riverSize,
                               int rows, int cols,int[][]visited){
        if(visited[i][j] == 1)
            return 0;
        else if(visited[i][j]!=1)
            visited[i][j] = 1;
        if(i< rows-1 && matrix[i+1][j] == 1)
            riverSize =  traverse(matrix, i+1, j, riverSize+1,rows,cols,visited);
        if(j< cols-1 && matrix[i][j+1] == 1)
            riverSize = traverse(matrix, i, j+1, riverSize + 1,rows,cols,visited);

        return riverSize;
    }
}
