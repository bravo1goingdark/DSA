public class SegmentTree {
    private static class Node {
        int value;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int startInterval , int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr , 0 , arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        // leaf Node
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node newNode = new Node(start, end);
        int mid = (start + end) /2;
        newNode.left = this.constructTree(arr, start, mid);
        newNode.right = this.constructTree(arr, mid + 1, end);

        newNode.value = newNode.left.value + newNode.right.value;
        return newNode;
    }
}
