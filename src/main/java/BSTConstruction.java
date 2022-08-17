public class BSTConstruction {
     static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }


         public static void generate(){
             int[] insert = new int[]{5,15,2,5,13,22,1,14,12};
             BST bst = new BST(10);
             for(Integer i :insert){
                bst.insert(i);
             }
             System.out.println(bst);
             bst.remove(10);
        }

        public  BST insert(int value) {
            BST currentNode = this;
            BST newNode = new BST(value);
            while(true){
                if(currentNode.value <= value){
                    if(currentNode.right == null){
                        currentNode.right = newNode;
                        break;
                    }
                    currentNode = currentNode.right;
                }
                else{
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        break;
                    }
                    currentNode = currentNode.left;
                }
            }

            return this;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while(currentNode != null) {
                if(currentNode.value < value){
                    currentNode = currentNode.right;
                }
                else if (currentNode.value > value){
                    currentNode = currentNode.left;
                }
                else{
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            BST currentNode = this;
            if(!currentNode.contains(value))
                return currentNode;

            if(currentNode.left == null && currentNode.right == null && currentNode.value ==value)
                return null;

            while(true){
                if(currentNode.value < value){
                    currentNode = currentNode.right;
                }
                else if (currentNode.value > value){
                    currentNode = currentNode.left;
                }
                else{
                    break;
                }

            }
            BST replacementNode =null;
            if(currentNode.right == null)
                replacementNode = currentNode.left;
            else
                replacementNode = currentNode.right;
            //currently the current node is at the element to be removed
            while(replacementNode.left!=null)
                replacementNode = replacementNode.left;

            currentNode.value = replacementNode.value;
            replacementNode = null;

            return this;
        }

    }
}
