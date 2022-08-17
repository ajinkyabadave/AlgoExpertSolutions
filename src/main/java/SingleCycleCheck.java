public class SingleCycleCheck {
    // Write your code here.
    public static boolean hasSingleCycle(int[] array){
        boolean[] hasVisited = new boolean[array.length];
        int i=0;
        int nextIndex;

            while(true){
            nextIndex = i + array[i];
            if(nextIndex < 0)
                i = array.length  - Math.abs(nextIndex);
            else if(nextIndex >= array.length)
                i = nextIndex % array.length;
            else
                i = nextIndex;

            if(i == 0)
                return checkIfAllPositionsVisited(hasVisited);

            hasVisited[i] = true;
        }

}

    public static boolean checkIfAllPositionsVisited(boolean[] hasVisited){
        for(int i = 1; i < hasVisited.length; i++){
            if(!hasVisited[i])
                return false;
        }
        return true;
    }
}
