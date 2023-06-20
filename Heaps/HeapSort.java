public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr , n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            swap(arr, 0, i);

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int size, int rootIndex) {
        int largestIndex = rootIndex;
        int leftchildIndex = 2*rootIndex + 1;
        int rightchildIndex = 2*rootIndex + 2;

        if (leftchildIndex < size && arr[leftchildIndex] > arr[largestIndex]) {
            largestIndex = leftchildIndex;
        }

        // Compare the root with its right child
        if (rightchildIndex < size && arr[rightchildIndex] > arr[largestIndex]) {
            largestIndex = rightchildIndex;
        }

        // If the largest element is not the root, swap them and recursively heapify the affected subtree
        if (largestIndex != rootIndex) {
            swap(arr, rootIndex, largestIndex);
            heapify(arr, size, largestIndex);
        }
    }

    private static void swap(int[] arr, int rootIndex, int largestIndex) {
        int temp = arr[rootIndex];
        arr[rootIndex] = arr[largestIndex];
        arr[largestIndex] = temp;
    }
}
