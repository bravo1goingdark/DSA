import java.util.ArrayList;
import java.util.Stack;


public class Question {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getmax(heights , stack , max , i);
            }
            stack.push(i);
        }
        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getmax(heights, stack, max, i);
        }
        return max;
    }

    private static int getmax(int[] arr, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = arr[popped] * i;
        }
        else {
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '('  ) {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{' ) {
                        return false;
                    }
                }

                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public int kthFactor(int n, int k) {
        if (n == k) {
            return -1;
        }
       ArrayList<Integer> list = new ArrayList<>();
       
       for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            list.add(i);
        } else {
            i++;
        }
       }

       for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i) == k) {
            return k;
        }
       }
       return 0;
    }
}

    
