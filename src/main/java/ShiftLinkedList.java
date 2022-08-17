public class ShiftLinkedList {

        public static int length;
        public static LinkedList shiftLinkedList(LinkedList head, int k) {
            LinkedList currentNode = head;
            length = 0;
            while(currentNode != null){
                currentNode = currentNode.next;
                length++;
            }

            k = k % length;
            LinkedList newHead;
            if(k>0)
                newHead = forwardShift(head,k);
            else
                newHead = backwardShift(head,k);

            return newHead;
        }

        public static LinkedList forwardShift(LinkedList head,int k){
            LinkedList currentNode = head;

            for(int i=0; i< (length - k -1); i++){
                currentNode = currentNode.next;
            }
            LinkedList nodesToShiftHead = currentNode.next;
            currentNode.next = null;

            currentNode = nodesToShiftHead;
            while(currentNode.next !=null)
                currentNode = currentNode.next;

            currentNode.next = head;
            head = nodesToShiftHead;
            return head;
        }

        public static LinkedList backwardShift(LinkedList head, int k){
            return null;
        }

        static class LinkedList {
            public int value;
            public LinkedList next;

            public LinkedList(int value) {
                this.value = value;
                next = null;
            }
        }
        public static LinkedList createLinkedList(Integer[] array) {
            LinkedList head = new LinkedList(array[0]);
            LinkedList currentNode = head;
            for (int i = 1; i < array.length; i++) {
                currentNode.next = new LinkedList(array[i]);
                currentNode = currentNode.next;
            }

            LinkedList curr = head;
            curr = curr.next;
            curr = curr.next;

            curr = null;



            return head;
        }

}
