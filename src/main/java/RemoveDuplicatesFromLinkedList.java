public class RemoveDuplicatesFromLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode= linkedList;

        while(currentNode!=null && currentNode.next != null){
            LinkedList nextDistinctNode = currentNode.next;
            while(nextDistinctNode!=null && nextDistinctNode.value == currentNode.value){
                nextDistinctNode = nextDistinctNode.next;
            }
                currentNode.next = nextDistinctNode;
                currentNode = currentNode.next;
        }

        return linkedList;
    }

    public static LinkedList generateLinkedList(int[] values) {
        LinkedList head = new LinkedList(values[0]);
        LinkedList currentNode = head;
        for (int i = 1; i < values.length; i++) {
            LinkedList newNode = new LinkedList(values[i]);
            currentNode.next = newNode;
            currentNode = newNode;
        }
        return head;
    }
}
