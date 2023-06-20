package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list  = new LinkedList();
        
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(4);
        list.display();
        LinkedList list2 = new LinkedList();
        list2.insertAtLast(1);
        list2.insertAtLast(3);
        list2.insertAtLast(4);
        list2.display();
        LinkedList ans = LinkedList.merge(list, list2);
        ans.display();

// doubly linked list
        // DLL list  = new DLL();
        // list.insertAtFirst(4);
        // list.insertAtFirst(3);
        // list.insertAtFirst(2);
        // list.insertAtFirst(1);
        // list.display();
        // list.insertAtLast(5);
        // list.display();
        // list.insertAtindex(2, 4);
        // list.display();

    //     CLL list = new CLL();
    //     list.insert(10);
    //     list.insert(6);
    //     list.insert(5);
    //     list.display();
    //     list.delete(6);
    //     list.display();
    // }

  
   }
}
