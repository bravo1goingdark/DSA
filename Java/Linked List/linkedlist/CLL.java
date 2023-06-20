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


    private class Node{
        private int value;
        private Node next;
    
        public Node(int value) {
            this.value = value;
        }
        public Node(int value , Node next){
            this(value);
            this.next = next;
        }  
    }
}
