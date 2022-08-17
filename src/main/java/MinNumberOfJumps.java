import java.util.Arrays;

public class MinNumberOfJumps {
    public static int minNumberOfJumps(int[] array) {
        int[] output = new int[array.length];
        Arrays.fill(output,Integer.MAX_VALUE);
        output[0] =0;
        for(int i=0;i<array.length;i++){
            int jumps = array[i];

            while(jumps>0){
                int idx;
                if( i + jumps > array.length-1)
                    idx = array.length -1;
                else
                    idx = i + jumps;
                System.out.println(" i  jumps and idx is" + i +" "+ jumps + " "+idx);
                output[idx] = Math.min(output[idx],output[i]+1);
                jumps--;
            }


        }
        return array[array.length-1];
    }
}
