import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    public class Node {
        private int value;
        private int height;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
        
    }
    private Node root;

    public BST() {

    }
    

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int value) {
        root = insert(value, root);
    }
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }
    public void populatesorted(int[] nums) {
        populatesorted(nums , 0 , nums.length);
    }

    private void populatesorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = ( end + start ) / 2;
        this.insert(nums[mid]);
        populatesorted(nums, start, mid);
        populatesorted(nums, mid + 1, end);

    }

    private Node insert(int value , Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left) , height(node.right)) + 1;

        return node;
    } 

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {

        if (root == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(this.root , "Root Node");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }
    public void BFS() {
        BFS(root);
    }

    private void BFS(Node node) {
        if (root == null) {
            return;
        }

        Queue<Node> que = new LinkedList<Node>();
        que.offer(root);


        while (!que.isEmpty()) {
            Node current = que.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                que.offer(current.left);
            }
            if (current.right != null) {
                que.offer(current.right);
            }
        }
    }
    public void DFS() {
        DFS(root);
    }


    private void DFS(Node node) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            System.out.print(current.value + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }
    public void recurDFS() {
        recurDFS(root);
    }


    private void recurDFS(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        recurDFS(node.left);
        recurDFS(node.right);
    }
}
