import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>((a,b) -> b-a);
        minheap = new PriorityQueue<>();
    }

    public void insert(int num) {
        if (maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.offer(num);
        }
        else {
            minheap.offer(num);
        }

        if (maxheap.size() - minheap.size() > 1) {
            minheap.offer(maxheap.remove());
        } else if(minheap.size() - maxheap.size() > 1) {
            maxheap.offer(minheap.remove());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else if (maxheap.size() > minheap.size()) {
            return maxheap.peek();
        }
        return minheap.peek();
    }

    
}
