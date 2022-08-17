public class RemoveIslands {

    public static int[][] removeIslands(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];

        // top row
        for(int j=0; j< cols; j++){
            if(matrix[0][j] == 1)
                traverse(matrix, 0,j, rows, cols,visited);
        }

        //bottom row
        for(int j=0; j< cols; j++){
            if(matrix[rows-1][j] == 1)
                traverse(matrix, rows-1,j, rows, cols,visited);
        }

        //first col
        for(int i=0; i< rows; i++){
            if(matrix[i][0] == 1)
                traverse(matrix, i,0, rows, cols,visited);
        }

        //last col
        for(int i=0; i< rows; i++){
            if(matrix[i][cols-1] == 1)
                traverse(matrix, i,cols-1, rows, cols,visited);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j] == 0 && matrix[i][j] == 1)
                    matrix[i][j] = 1;
            }
        }

        return matrix;
    }

    public static void traverse(int[][] matrix, int i, int j, int rows, int cols,
                                int[][] visited){
        if(visited[i][j] ==1)
            return;

        visited[i][j] = 1;

        if( i< rows-1 && matrix[i+1][j] ==1)
            traverse(matrix,i+1,j,rows,cols,visited);

        if(i> 0 && matrix[i-1][j] == 1)
            traverse(matrix,i-1,j,rows,cols,visited);

        if(j> 0 && matrix[i][j-1] == 1)
            traverse(matrix,i,j-1,rows,cols,visited);

        if(j< cols-1 && matrix[i][j+1] == 1)
            traverse(matrix,i,j+1,rows,cols,visited);

    }

}
