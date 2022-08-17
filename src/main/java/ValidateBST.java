public class ValidateBST {
    static boolean valid=true;
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

//    public boolean isValidBST(TreeNode root) {
//        valid = true;
//        dfs(root);
//        return valid;
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        if (!valid) {
//            return;
//        }
//        if (root.val <= min || root.val >= max) {
//            valid = false;
//            return;
//        }
//        min = root.val;
//        dfs(root.right);
//        max = root.val;
//    }
//}
    public static boolean validateBst(BST tree) {
        if(tree == null)
            return true;

        if(tree.left !=null && tree.left.value > tree.value)
            return false;

        if(tree.right !=null && tree.right.value <= tree.value)
            return false;

        valid = valid ? validateBst(tree.left):false;
        valid = valid? validateBst(tree.right):false;
        return valid;
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
