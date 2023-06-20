package linkedlist;
public class DLL {
    private Node head;


    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }
    public void insertAtLast(int value){
        Node node = new Node(value);
        Node lastNode = head;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = node;
        node.prev = lastNode;
    }
    public void insertAtindex(int aftervalue , int value){
        Node p = find(aftervalue);
        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }

    }
    public Node find(int value){
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
        Node(int value , Node next , Node prev){
            this(value);
            this.next = next;
            this.prev = prev;
        }
    }

    

}
