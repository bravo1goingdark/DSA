class AVLTree {
    Node root;
    
    int height(Node node) {
        if (node == null)
        return 0;
        return node.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    Node rotateRight(Node node) {
        Node parent = node.left;
        Node child = parent.right;
        
        parent.right = node;
        node.left = child;
        
        node.height = max(height(node.left), height(node.right)) + 1;
        parent.height = max(height(parent.left), height(parent.right)) + 1;
        
        return parent;
    }
    
    Node rotateLeft(Node parent) {
        Node node = parent.right;
        Node child = node.left;
        
        node.left = parent;
        parent.right = child;
        
        parent.height = max(height(parent.left), height(parent.right)) + 1;
        node.height = max(height(node.left), height(node.right)) + 1;
        
        return node;
    }
    
    int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    
    Node insert(Node node, int value) {
        if (node == null)
        return (new Node(value));
        
        if (value < node.value)
        node.left = insert(node.left, value);
        else if (value > node.value)
        node.right = insert(node.right, value);
        else
        return node;
        
        node.height = 1 + max(height(node.left), height(node.right));
        
        int balance = balanceFactor(node);
        
        if (balance > 1 && value < node.left.value)
        return rotateRight(node);

        if (balance < -1 && value > node.right.value)
            return rotateLeft(node);
            
            if (balance > 1 && value > node.left.value) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            
            if (balance < -1 && value < node.right.value) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
            
            return node;
        }
        
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }
        
        public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 20);
            tree.root = tree.insert(tree.root, 30);
            tree.root = tree.insert(tree.root, 40);
            tree.root = tree.insert(tree.root, 50);
            tree.root = tree.insert(tree.root, 25);
            
            System.out.println("Preorder traversal of constructed tree is:");
            tree.preOrder(tree.root);
        }
    }
    
    class Node {
        int value, height;
        Node left, right;
    
        Node(int d) {
            value = d;
            height = 1;
        }
    }