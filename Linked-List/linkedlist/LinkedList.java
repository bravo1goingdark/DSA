package linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    LinkedList() {
        this.size = 0;
    }
    public void insertAtFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size += 1;
    }
    public void insertAtLast(int value) {
        Node node = new Node(value);
        if(tail == null) {
            insertAtFirst(value);
            return;
        }

        tail.next = node;
        tail = node;
        size += 1;
    }
    public void insert(int value , int index) {
        if (index == 0) {
            insertAtFirst(value);
        }
        if (index == size) {
            insertAtLast(value);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size += 1;
    }
    public int deleteAtFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        size--;
        return val;      
    }
    public int delete(int index){
        if (index == 0) {
            deleteAtFirst();
        }
        if (index == size - 1) {
            deleteAtLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public int deleteAtLast() {
        if (size <= 1) {
            deleteAtFirst();
        }      
        Node secondlast = get(size - 2); // including null
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        return val;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    // Q -- insert using recursion
    public void insertrec(int val, int index){
        head = insertrec(val, index, head);
    }
    private Node insertrec(int value , int index , Node node){
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertrec(value, index = index - 1, node.next);
        return node;
    }
    // Q-- merge two sorted list
    public static LinkedList merge(LinkedList first , LinkedList second){
        Node f = first.head;
        Node s = second.head;

        LinkedList ans = new LinkedList();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertAtLast(f.value);
                f = f.next;
            } else {
                ans.insertAtLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertAtLast(f.value);
            f = f.next;
        }
        while (s != null) {
            ans.insertAtLast(s.value);
            s = s.next;
        }
        return ans;

    }
    public void duplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
            } else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    // reversse ll using recursion
    public void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
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



