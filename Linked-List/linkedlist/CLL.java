package linkedlist;
public class CLL {
    private Node head;
    private Node tail;

    CLL() {
        this.head = null;
        this.tail = null;
    }
    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display() {
        Node temp = head;
        if (head != null) {
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
            System.out.print("HEAD"); // pointing towards head 
        }
    }
    public void delete(int value){
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.value == value) {
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }


    private class Node{
        private int value;
        private Node next;
    
        public Node(int value) {
            this.value = value;
        }
    }
}
