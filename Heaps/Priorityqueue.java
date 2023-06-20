public class Priorityqueue {
    private int[] heap;
    private int size;

    Priorityqueue(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    Priorityqueue() {
        this(10);
    }

    public void insert(int value) {
        if (size == heap.length) {
            throw new IllegalStateException("heap is full");
        }
        heap[size] = value;
        heapifyUp(size++);
    }
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("heap is empty");
        }

        int maxValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return maxValue;
    }
    private void heapifyUp(int index) {
        int parentIndex = (index - 1)/2;

        while (index > 0 && heap[index] > heap[parentIndex]) { 
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1)/2;
        }

    }
    private void heapifyDown(int index) {
        int maxIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] > heap[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }
    public void display() {
        for (int i = 0; i < heap.length - 1; i++) {
            if (heap[i] == 0) {
                return;
            }
            System.out.print(heap[i] + " ");
        }
    }

    private void swap(int index1 , int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }



}
