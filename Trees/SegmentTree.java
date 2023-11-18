public class SegmentTree {
    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree(new int[]{3,8,7,6,-2,-8,4,9});
        System.out.println(tree.query(2, 6));
        tree.update(2, 100);
        System.out.println(tree.query(2, 5));
    }
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

    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if(node.startInterval >= qsi && node.endInterval <= qei) {
          // node is completely lying inside query
          return node.value;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
          // completely outside
          return 0;
        } else {
          return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
      }

    public void update (int index , int value){
        this.root.value = update(this.root , index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.value = value;
                return node.value;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.value = leftAns + rightAns;
                return node.value;
            }
        }

        return node.value;
    }
}
