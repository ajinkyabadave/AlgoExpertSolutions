import java.util.Arrays;

public class CycleInGraph {
    public static boolean cycleInGraph(int[][] edges) {
        int vertices = edges.length;
        int[] visited = new int[vertices];
        boolean res=false;
        for(int i=0; i< vertices; i++){

            System.out.println("edge is " + i);
            res = traverse(edges,i,visited);
            if(res)
                return res;
        }
        return res;

    }


    public static boolean traverse(int[][] edges, int i, int[] visited){
        int[] connections = edges[i];
        boolean res = false;
        visited[i]=1;

        for(int j=0; j<connections.length; j++){
//            Arrays.fill();
            int destination = edges[i][j];
            if(visited[destination] == 1){
                System.out.println("pos is "+ i+ " " + j + " " + destination);
                return true;

            }
            visited[destination] = 1;
            res = traverse(edges,destination,visited);
            if(res)
                return res;
        }

        return res;
    }
}
