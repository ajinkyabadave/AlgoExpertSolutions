//import static java.lang.Double.POSITIVE_INFINITY;

public class ClosestBST {


        public static int findClosestValueInBst(BST tree, int target) {
            // Write your code here.
            double difference = Double.POSITIVE_INFINITY;
            int closestValue = 0;

            while(tree != null){
                if(tree.value > target){
                    difference = tree.value - target;
                    closestValue = tree.value;
                    tree = tree.left;
                }
            }

            return -1;
        }

        static class BST {
            public int value;
            public BST left;
            public BST right;

            public BST(int value) {
                this.value = value;
            }
        }

}
