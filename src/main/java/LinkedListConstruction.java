import java.util.Stack;
import java.util.stream.Collectors;

public class LinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if(head == null){
                head = node;
                tail = node;
                return;
            }
            if(!isStandAlone(node)){
                Node previousNode = node.prev;

                if(previousNode !=null)
                    previousNode.next = node.next;

                node.prev = null;
                node.next.prev = previousNode;
            }
            node.next = head;
            head.prev = node;
            head = node;



        }

        public void setTail(Node node) {
            if(head == null){
                head = node;
                tail=node;
                return;
            }

            if(tail!=null && tail.value == node.value)
                return;

            if(!isStandAlone(node)){
                Node previousNode = node.prev;
                if(previousNode !=null)
                    previousNode.next = node.next;

                node.next.prev = previousNode;
                node.next = null;
            }
            node.prev = tail;
            tail.next = node;
            tail = node;

        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if(!isStandAlone(nodeToInsert)){
                Node temp = nodeToInsert.prev;
                if(temp!=null)
                    temp.next = nodeToInsert.next;

                if(nodeToInsert.next !=null)
                    nodeToInsert.next.prev = temp;

                nodeToInsert.next = null;
                nodeToInsert.prev = null;
            }

            Node previousNode= node.prev;

            nodeToInsert.next = node;
            node.prev = nodeToInsert;
            previousNode.next = nodeToInsert;
            nodeToInsert.prev = previousNode;

        }

        public void insertAfter(Node node, Node nodeToInsert) {
            Stack<String> as = new Stack<>();

            if(!isStandAlone(nodeToInsert)){
                Node temp = nodeToInsert.prev;
                if(temp!=null)
                    temp.next = nodeToInsert.next;

                if(nodeToInsert.next !=null)
                    nodeToInsert.next.prev = temp;

                nodeToInsert.next = null;
                nodeToInsert.prev = null;
            }

            Node nextNode = node.next;

            node.next = nodeToInsert;
            nodeToInsert.prev = node;
            nodeToInsert.next = nextNode;
            if(nextNode!=null)
                nextNode.prev = nodeToInsert;
            else
                tail = nodeToInsert;
        }
        public void insertAtPosition(int position, Node nodeToInsert) {
            Node currNode = head;
            int size = 0;
            while(currNode!= null){
                currNode = currNode.next;
                size++;
            }
            if(position == 1 )
                insertBefore(head,nodeToInsert);
            else if(position == size+1)
                insertAfter(tail,nodeToInsert);
            else{
                currNode = head;
                for(int i=1; i<position; i++){
                    currNode = currNode.next;
                }
                insertBefore(currNode,nodeToInsert);
            }

        }

        public void removeNodesWithValue(int value) {
            Node currNode = head;
            while(currNode!=null){
                if(currNode.value == value){
                    Node nodeToRemove = currNode;
                    currNode = currNode.next;
                    removeElement(nodeToRemove);
                    continue;
                }
                currNode = currNode.next;
            }
        }

        public void remove(Node node) {
            Node currNode = head;
            while(currNode!=null && currNode.value!= node.value)
                currNode = currNode.next;

            removeElement(currNode);
            currNode = null;
        }

        private void removeElement(Node currNode) {
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;

            if(prevNode!=null)
                prevNode.next = nextNode;
            if(nextNode!=null)
                nextNode.prev = prevNode;

            currNode.prev = null;
            currNode.next = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node currNode = head;
            while(currNode!=null && currNode.value!= value)
                currNode = currNode.next;
            if(currNode!=null && currNode.value == value)
                return true;

            return false;
        }

        public boolean isStandAlone(Node node){
            if(node.next == null && node.prev == null)
                return true;
            return false;
        }

        public DoublyLinkedList generate(){
            Node head = new Node(1);
            DoublyLinkedList list = new DoublyLinkedList();
            list.head = head;
            list.tail = head;

            insertAfter(tail,new Node(2));
            insertAfter(tail,new Node(3));
            insertAfter(tail,new Node(4));
            insertAfter(tail,new Node(5));
            return list;

        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


}
