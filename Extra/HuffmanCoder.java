import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoder {
    private Map<Character, String> encoder;
    private Map<String, Character> decoder;
    


    public HuffmanCoder(String feeder){
        Map<Character,Integer> freqMap = new HashMap<>();

        for (Character ch : feeder.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            }else {
                freqMap.put(ch, 1);
            }
        }

        Set<Map.Entry<Character,Integer>> entrySet = freqMap.entrySet();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (Map.Entry<Character,Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.offer(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;
            minHeap.offer(newNode);
        }

        Node huffmanTree = minHeap.remove();
        

    }

    public class Node implements Comparable<Node> {
        private Character data;
        private int cost;
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}