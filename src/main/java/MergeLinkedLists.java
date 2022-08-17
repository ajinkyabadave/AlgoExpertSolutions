public class MergeLinkedLists {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList solution;
        if(headOne.value < headTwo.value)
            solution = headOne;
        else solution = headTwo;

        LinkedList nextNode;
        LinkedList solNode = solution;

        while(headOne !=null && headTwo !=null ){

            if(headOne.value <= headTwo.value){
                nextNode = headOne.next;

                if(nextNode!=null && nextNode.value > headTwo.value){
                    headOne.next = headTwo;
                }
                headOne = nextNode;
            }
            else if(headOne.value > headTwo.value){
                nextNode = headTwo.next;
                if(nextNode!=null && nextNode.value > headOne.value){
                    headTwo.next = headOne;
                }
                headTwo = nextNode;
            }
        }
        while(solNode.next!=null)
            solNode = solNode.next;
        if(headOne != null && headOne!=solNode)
            solNode.next = headOne;

        else if(headTwo != null && headTwo !=solNode)
            solNode.next = headTwo;
        return solution;

    }
    public static LinkedList generateLinkedList(int[] values) {
        LinkedList head = new LinkedList(values[0]);
         LinkedList currentNode = head;
        for (int i = 1; i < values.length; i++) {
             LinkedList newNode = new  LinkedList(values[i]);
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return head;
    }
}
