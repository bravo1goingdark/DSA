import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Question {
    public static void main(String[] args) {
        String s = reversePrefix("rzwuktxcjfpamlonbgyieqdvhs", 's');
        System.out.println(s);

    }

    public long findTheArrayConcVal(int[] nums) {
        int conc = 0;
        int start = 0;
        int end = nums.length - 1;

        while (end > start) {
            conc += concat(nums[start], nums[end]);
            start++;
            end--;   
        }
        if (start == end) {
            conc += nums[start];
        }

        return conc;
    }
    public boolean isPowerOfTwo(int n) {
        double x = Math.log(n) / Math.log(2);
        if (x != (int) x) {
            return false;
        }
        return true;
    }

    static long concat(long start, long end)
    { 
        String value = Long.toString(start) + Long.toString(end);
        return  Long.parseLong(value);
    }

    public static double[] convertTemperature(double celsius) {
        double[] ans;
        double Kelvin = celsius + 273.15;
        double Fahrenheit = celsius * 1.80 + 32.00;

        return ans = new double[]{Kelvin , Fahrenheit};
    }
    public static int arraySign(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }

        return signFunc(product);
        
    }

    private static int signFunc(int product) {
        if (product == 0) {
            return 0;
        }
        if (product > 0) {
            return 1;
        }
        return - 1;
    }
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }

    static void swap(char[] arr , int start , int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public String reverseOnlyLetters(String s) {
        String ch = "";
        int len = s.length() - 1;
        while (len >= 0) {
            if ((s.charAt(len) >= 'a' && s.charAt(len) <= 'z') || (s.charAt(len) >= 'A' && s.charAt(len) <= 'Z')) {
                ch += s.charAt(len);
                len--;
            } else {
                len--;
            }
        }
        return ch;

    }
    public static String reversePrefix(String word, char ch) {
        int start = 0;
        int end = getEnd(word , ch);
        if (end == -1) {
            return word;
        }
        char[] arr = word.toCharArray();
        while (end > start) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

    private static int getEnd(String word, char ch) {
        for (int i = 0; i <= word.length() - 1; i++) {
            if (ch == word.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int remainsum = targetSum - root.val;

        if(root.left == null && root.right == null && remainsum == 0) {
            return true;
        }

        return hasPathSum(root.left, remainsum) || hasPathSum(root.right, remainsum);
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }

        return minDepth + 1;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null ) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        } else {
            sum = sumOfLeftLeaves(root.left);  // Recursively traverse the left subtree
        }
        
        int rightSum = sumOfLeftLeaves(root.right);  // Recursively traverse the right subtree
        
        return sum + rightSum;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean isleftSame = isSameTree(p.left, q.left);
        boolean isrightSame = isSameTree(p.right, q.right);
        
        return isleftSame && isrightSame;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> clevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                clevel.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            list.add(clevel);
        }
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root , list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    griddfs(grid, i , j);
                }
            }
        }
        return count;
    }

    private void griddfs(char[][] grid, int row, int col) {
        int numrow = grid.length;
        int numcol = grid[0].length;

        if (row < 0 || col < 0 || row >= numrow || col >= numcol || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        griddfs(grid, row - 1, col);
        griddfs(grid, row + 1, col);
        griddfs(grid, row, col - 1);
        griddfs(grid, row, col + 1);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return toBST(nums , 0 , nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end ) {
            return null;
        }

        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);

        
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSum(root, sum, currentPath, paths);
        return paths;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null && sum == node.val) {
            paths.add(new ArrayList<>(currentPath));
        }

        pathSum(node.left, sum - node.val, currentPath, paths);
        pathSum(node.right, sum - node.val, currentPath, paths);

        currentPath.remove(currentPath.size() - 1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        binaryTreePaths(root , "" , list);
        return list;
    }

    private void binaryTreePaths(TreeNode root, String paths, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(paths + root.val);
            return;
        }
        paths += root.val + "->";
        if (root.left != null) {
            binaryTreePaths(root.left, paths, list);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, paths, list);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            double avglevel = 0;
            int levelsize = que.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currNode = que.poll();
                avglevel += currNode.val;

                if (currNode.left != null) {
                    que.offer(currNode.left);
                }

                if (currNode.right != null) {
                    que.offer(currNode.right);
                }
                
            }
            avglevel /= levelsize;
            result.add(avglevel);

        }
        return result;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> que = new LinkedList<>();
        que.offerFirst(root);

        boolean rev = false;

        while (!que.isEmpty()) {
            int lvlsize = que.size();
            List<Integer> currlevel = new ArrayList<>();

            for (int i = 0; i < lvlsize; i++) {
                
                if (!rev) {
                    TreeNode currNode = que.pollFirst();
                    currlevel.add(currNode.val);

                    if (currNode.left != null) {
                        que.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        que.addLast(currNode.right);
                    }
                } else {
                    TreeNode currNode = que.pollLast();
                    currlevel.add(currNode.val);

                    if (currNode.right != null) {
                        que.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        que.addFirst(currNode.left);
                    }
                }

                rev = !rev;
                
            }
            result.add(currlevel);

        }

        return result;
    }

    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            int levelsize = que.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currNode = que.poll();
                
                if (i == levelsize - 1) {
                    result.add(currNode.val);
                }

                if (currNode.left != null) {
                    que.offer(currNode.left);
                }

                if (currNode.right != null) {
                    que.offer(currNode.right);
                }
                
            }
        }
        return result;
    }
    public String tree2str(TreeNode root) {
        if (root == null) {
            return " ";
        }
        StringBuilder str = new StringBuilder();
        str.append(root.val);

        if (root.left != null || root.right != null) {
            str.append("(");
            str.append(tree2str(root.left));
            str.append(")");

            if (root.right != null) {
                str.append("(");
                str.append(tree2str(root.right));
                str.append(")");
            }
        }
        return str.toString();
    }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


