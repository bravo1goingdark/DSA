import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        maxHeap heap = new maxHeap();
        
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(16);
        heap.insert(60);
        heap.display();
        int max = heap.extractMax();
        System.out.println();
        System.out.println(max);
        heap.display();

        int[] arr = {4,2,6,1,3,5};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        Priorityqueue que = new Priorityqueue();
        que.insert(5);
        que.insert(8);
        que.insert(3);
        que.insert(10);
        que.insert(1);
        que.insert(7);
        que.insert(6);
        System.out.println();
        que.display();
        que.remove();
        que.display();
        que.remove();
        que.display();
        que.remove();
        que.display();
        while (que.isEmpty()) {
            
        }


        
    }
}
