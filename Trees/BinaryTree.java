import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }
    
    private Node root;

    public void delete(int key) {
        root = deleteNode(root, key);
    }
    
    private Node deleteNode(Node node, int key) {
        if (node == null) {
            return node;
        }
    
        if (key < node.value) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.value) {
            node.right = deleteNode(node.right, key);
        } else {
            // Case 1: Node with no child or only one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
    
            // Case 2: Node with two children
            Node successor = findSuccessor(node.right);
            node.value = successor.value;
            node.right = deleteNode(node.right, successor.value);
        }
    
        return node;
    }
    
    private Node findSuccessor(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    
    
    // insert element
    public void populate(Scanner in) {
        System.out.println("Enter the root node value ");
        int value = in.nextInt();
        root = new Node(value);
        populate(in , root);
    }


    private void populate(Scanner in, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = in.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = in.nextInt();
            node.left = new Node(value);
            populate(in, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = in.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = in.nextInt();
            node.right = new Node(value);
            populate(in, node.right);
        }
    }
    public void display() {
        display(root , "");
    }

    
    private void display(Node node, String space) {
        if (node == null) {
            return;
        }
        System.out.println(space + node.value);
        display(node.left, space + "\t");
        display(node.right, space + "\t");
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node , int level) {
        if (node == null) {
            return;
        }
        
        prettyDisplay(node.right, level + 1);
        
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
                
            }
            System.out.println("|--------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void InOrder(){
        InOrder(root);

    }
    private void InOrder(Node node) {
        if (node == null) {
            return;

        }
        InOrder(node.left);
        System.out.println(node.value + " ");
        InOrder(node.right);
    }
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }
    public static class Node {
        int value;
        Node left;
        Node right;

        Node (int value) {
            this.value = value;
        }
    }
}