import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class KthSmallestElemntInBST {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public static int count=0;
    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        Stack<TreeNode> stack = new Stack<>();

        stack.stream().map(t->t.val).toArray()

        System.out.println(
                Arrays.toString(stack.toArray()).stream().map(t->t.value)
                .collect(Collectors.toList()));

        String s =
                "abcawr";

//        s.toLowerCase().cha

        return traverse(root);


    }


    public static int traverse(TreeNode node){

        if(node == null)
            return 0;

        traverse(node.left);

        count--;
        if(count ==0)
            return node.val;

        traverse(node.right);

        count--;
        if(count ==0)
            return node.val;

        return 0;
    }
}
//        KthSmallestElemntInBST.TreeNode fourNode = new KthSmallestElemntInBST.TreeNode(4);
//        KthSmallestElemntInBST.TreeNode sixNode = new KthSmallestElemntInBST.TreeNode(6);
//        KthSmallestElemntInBST.TreeNode oneNode = new KthSmallestElemntInBST.TreeNode(1,null, null);
//        KthSmallestElemntInBST.TreeNode twoNode = new KthSmallestElemntInBST.TreeNode(2,oneNode,null);
//        KthSmallestElemntInBST.TreeNode threeNode = new KthSmallestElemntInBST.TreeNode(3,twoNode, fourNode);
//        KthSmallestElemntInBST.TreeNode fiveNode = new KthSmallestElemntInBST.TreeNode(5,threeNode, sixNode);
//        KthSmallestElemntInBST.kthSmallest(fiveNode,3);