import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReconstructBST {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // hint 2 tells the solution

        BST root = new BST(preOrderTraversalValues.get(0));
        return constructBst(preOrderTraversalValues,null, root);
    }
    public static BST constructBst(List<Integer> subTree,
                                   String side, BST node){

        if(subTree.size() == 1){
            // int ele= leftSubtree.get(0);
            // if(side.equals("left"))
            //   node.left = ele ;
            // else
            //   node.right = ele;
            return node;
        }

        int idx = 1;
        while(idx < subTree.size() &&(subTree.get(idx) < subTree.get(0)))
            idx++;


        node.left = idx==1? null : constructBst(subTree.subList(1,idx),
                "left",new BST(subTree.get(1)));

        node.right  = idx == subTree.size()?null : constructBst(subTree.subList(idx,subTree.size()),
                "right",new BST(subTree.get(idx)));
        return node;
    }
}
