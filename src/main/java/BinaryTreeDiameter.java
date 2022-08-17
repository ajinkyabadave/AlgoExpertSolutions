import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDiameter {
    static int diameter;
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        diameter = 0;
        binaryTreeDiameterRec(tree);
        return diameter;
    }

    public static int binaryTreeDiameterRec(BinaryTree node) {
        if(node == null)
            return -1;

        int leftHeight = binaryTreeDiameterRec(node.left);
        int rightHeight = binaryTreeDiameterRec(node.right);
        int maxHeight = Math.max(leftHeight,rightHeight);
        int nodeDia = 2 + leftHeight + rightHeight;
        if(diameter < nodeDia)
            diameter = nodeDia;

        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);


        return 1+maxHeight;
    }

    public static BinaryTree createTree(){
        BinaryTree n1 = new BinaryTree(9);
        BinaryTree n2 = new BinaryTree(8); n2.left=n1;
        BinaryTree n4 = new BinaryTree(7); n4.left=n2;
        BinaryTree n5 = new BinaryTree(3); n5.left = n4;
        BinaryTree n6 = new BinaryTree(6);
        BinaryTree n7 = new BinaryTree(5); n7.right = n6;
        BinaryTree n8 = new BinaryTree(4); n8.right = n7;
        n5.right= n8;
        BinaryTree n9 = new BinaryTree(2);
        BinaryTree n10 = new BinaryTree(1); n10.left = n5; n10.right = n9;

        return n10;


    }

    public void traverse(BinaryTree node){
        if(node == null)
            return;
        System.out.println(node.value);
        traverse(node.left);
        traverse(node.right);
    }
}
