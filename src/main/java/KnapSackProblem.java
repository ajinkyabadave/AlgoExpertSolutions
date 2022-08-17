//import java.util.*;
//
//public class KnapSackProblem {
//    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
//        int rows = items.length+1;
//        int cols = capacity+1;
//        int[][] matrix = new int[rows][cols];
//        List<List<Integer>> solutionss = new ArrayList<>();
//        solutionss.add(Arrays.asList(0));
//        solutionss.add(new ArrayList<Integer>());
//
//        for(int row = 1; row < rows;row++){
//            for(int col = 1; col< cols; col++){
//                int weight = items[row-1][1];
//                if(weight > col){
//                    matrix[row][col] = matrix[row-1][col];
//                }
//                else{
//                    matrix[row][col] = Math.max(matrix[row-1][col],
//                            matrix[row-1][col-weight] + weight);
//                }
//            }
//        }
//
//        int row = rows-1;
//        int col = cols-1;
//        while(row>0 && col>0){
//            // if equal then nothing was added from current
//            if(matrix[row][col] == matrix[row-1][col]){
//                row = row--;
//            }
//            else{
//                List<Integer> currentElement = solutionss.get(1);
//                int prevWeight = solutionss.get(0).get(0);
//                int currentWeight = items[row-1][1];
//
//                currentElement.add(row-1);
//                prevWeight = prevWeight + curentWeight;
//                solutions.set(0, Arrays.asList(prevWeight));
//                solutions.set(1,currentElement);
//
//                row--;
//                col = col-currentWeight;
//            }
//        }
//
//        // for(int row = 0; row < rows;row++){
//        //    for(int col = 0; col< cols; col++){
//        //      System.out.println(" value: " + row + " " + col+ " " + matrix[row][col]);
//        //    }
//        //  }
//        return solutions;
//    }
//}
