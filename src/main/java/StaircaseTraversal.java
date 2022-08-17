public class StaircaseTraversal {
    public static int staircaseTraversal(int height, int maxSteps) {

        int[] solution = new int[height+1];
        solution[height] = 1;
        // solution[height-1] = 1;

        int start = height-1;
        int end = start+maxSteps-1;

        int ways = 0;
        for(int i=height-1; i>=0; i--){
            if(start==end)
                ways = solution[start];
            else

            solution[i]=ways;


        }

        return solution[0];
    }
}
