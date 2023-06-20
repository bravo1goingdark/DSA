public class maxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public maxHeap() {
        this(10);
    }
    public maxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = -1;
    }

    public void insert(int value) throws Exception {
        if (size == capacity - 1) {
            throw new Exception("Heap is full");
        }
        heap[++size] = value;
        heapifyUp(size);
    }
    public int extractMax() throws Exception{
        if (isEmpty()) {
            throw new Exception("heap is full");
        }
        int maxValue = heap[0];
        heap[0] = heap[size];
        size--;
        heapifyDown(0);
        return maxValue;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex >= 0 && heap[parentIndex] < heap[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }
    private void heapifyDown(int index) {
        int largestIndex = index;
        int leftchildIndex = 2*index + 1;
        int rightchildIndex = 2*index + 2;

        if (largestIndex <= size && heap[leftchildIndex] > heap[largestIndex]) {
            largestIndex = leftchildIndex;
        } 
        if (largestIndex <= size && heap[rightchildIndex] > heap[largestIndex]) {
            largestIndex = rightchildIndex;
        }
        if (largestIndex != index) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }
    public void display() {
        for (int i = 0; i < heap.length - 1; i++) {
            if(heap[i] == 0) {
                return;
            } else {
                System.out.print(heap[i] + " ");
            }
        }
    }
    private void swap(int index1 , int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private boolean isEmpty() {
        return size == -1;
    }
}
