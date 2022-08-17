import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        List<Integer> preReq = new ArrayList<>();
        HashMap<Integer,List<Integer>> graph= buildGraph(deps,jobs,preReq);
        Stack<Integer> solution = new Stack<>();

        while(!preReq.isEmpty()){
            solution.add(preReq.remove(0));
        }
        Integer[] array = (Integer[]) solution.toArray();
//        array.





        return new ArrayList<Integer>();
    }

    public static HashMap<Integer, List<Integer>> buildGraph(List<Integer[]> deps, List<Integer> jobs,List<Integer> preReq){
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Boolean> jobsGraph = new HashMap<>();
        for(Integer j: jobs){
            jobsGraph.put(j,false);
        }

        for(Integer[] array :deps){
            List<Integer> childJobs = new ArrayList<>();
            childJobs = graph.getOrDefault(array[0],childJobs);

            Integer dependantJob = array[1];
            jobsGraph.put(dependantJob,true);

            childJobs.add(dependantJob);
            graph.put(array[0],childJobs);
        }

        for(Map.Entry<Integer,Boolean> entry: jobsGraph.entrySet()){
            if(!entry.getValue())
                preReq.add(entry.getKey());
        }
        return graph;
    }

}
