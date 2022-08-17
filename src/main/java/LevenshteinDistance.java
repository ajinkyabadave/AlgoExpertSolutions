import java.util.*;
import java.util.stream.Collectors;

public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];

        int init = 0;
        for(int i=0; i<= str1.length(); i++){
            matrix[i][0] = init;
            init++;
        }

        init = 0;
        for(int i=0; i<= str2.length(); i++){
            matrix[0][i] = init;
            init++;
        }

        int row = 1;
        int col = 1;
        for(int i=0; i< (str1.length() * str2.length()); i++){
            if( str1.charAt(row-1) == str2.charAt(col-1)){
                matrix[row][col] = matrix[row-1][col-1];
            }
            else{
                matrix[row][col] = 1 + Math.min( Math.min(matrix[row-1][col] , matrix[row-1][col-1]),
                        matrix[row][col-1]);
            }
            if(col == str2.length()){
                row++;
                col = 1;
            }
            else
                col++;
        }


        return matrix[str1.length()][str2.length()];
    }
}
