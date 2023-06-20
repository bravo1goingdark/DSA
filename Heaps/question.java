import java.util.PriorityQueue;

public class question {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add elements to the min-heap
        for (int num : nums) {
            minHeap.offer(num);
            
            // If the size of the min-heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The top element of the min-heap will be the kth largest element
        return minHeap.peek();
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (Integer stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int firstmax = maxHeap.poll();
            int secondmax = maxHeap.poll();
            int modweight = firstmax - secondmax;
            if (modweight > 0) {
                maxHeap.offer(modweight);
            }

        }
        return maxHeap.isEmpty() ? 0:maxHeap.poll();

    }
    public int[] topKFrequent(int[] nums, int k) {
        
    }
}
