import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {
    static class MinHeap {
        static List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
            System.out.println("Sorted array");
            isMinHeapPropertySatisfied(heap);

            int k=0;
            List<Integer> arr1 = new ArrayList<>();

            while(k<heap.size()){
                arr1.add(remove());
//                System.out.println(remove());
            }
            List<Integer> arr2 = new ArrayList<>(arr1);
            Object[] arr2a = arr2.toArray();
            Arrays.sort(arr2a);

            for(int i=0;i<arr1.size();i++){
                if(arr1.get(i) != arr2a[i]){
                    System.out.println("i " + i);
                }
            }

        }

        public static List<Integer> buildHeap(List<Integer> array) {
            int firstParentIndex = (array.size()-2)/2;
            for(int i=firstParentIndex; i>=0; i--){
                siftDown(i,array.size()-1,array);
            }




            return array;
        }

        public static void siftDown(int currentIdx, int endIdx, List<Integer> heap) {

            int childOneIdx = currentIdx*2 + 1;
            int childTwoIdx = (currentIdx+1) * 2;
            int minChildIdx;

            if(childOneIdx <= endIdx && childTwoIdx<= endIdx){
                int childOne = heap.get(childOneIdx);
                if(childTwoIdx > endIdx){
                    minChildIdx = childOneIdx;
                }
                else{
                    if(heap.get(childOneIdx) > heap.get(childTwoIdx)){
                        minChildIdx = childTwoIdx;
                    }
                    else{
                        minChildIdx = childOneIdx;
                    }
                }
                int parent = heap.get(currentIdx);

                if(parent > heap.get(minChildIdx)){


                    heap.set(currentIdx, heap.get(minChildIdx));
                    heap.set(minChildIdx, parent);
                    siftDown(minChildIdx, heap.size()-1, heap);
                }
                else{
                    return;
                }

            }
        }

        public static void siftUp(int currentIdx, List<Integer> heap) {
            if(currentIdx<1)
                return;

            int parentIdx =(currentIdx-1)/2;
            int parent = heap.get(parentIdx);
            if( parent > heap.get(currentIdx)){
                heap.set(parentIdx, heap.get(currentIdx));
                heap.set(currentIdx, parent);
            }
            siftUp(parentIdx,heap);
        }

        public static int peek() {
//            for(int h = 0; h< heap.size();h++){
//                System.out.println("heap is:" + h + " " + heap.get(h));
//            }
            return heap.get(0);
        }

        public static int remove() {
            int lastElement = heap.get(heap.size()-1);
            int elementToRemove = peek();
            heap.set(0,lastElement);
            heap.set(heap.size()-1,elementToRemove);
            heap = new ArrayList<>(heap);
            heap.remove(heap.size()-1);
            siftDown(0,heap.size()-1,heap);
            return elementToRemove;
        }

        public static void insert(int value) {
            heap.add(value);
            int idx = heap.size()-1;
            siftUp(idx,heap);
        }

        boolean isMinHeapPropertySatisfied(List<Integer> array) {
            for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
                int parentIdx = (currentIdx - 1) / 2;
                if (parentIdx < 0) {
                    return true;
                }
                if (array.get(parentIdx) > array.get(currentIdx)) {
                    return false;
                }
            }

            return true;
        }
    }
}
