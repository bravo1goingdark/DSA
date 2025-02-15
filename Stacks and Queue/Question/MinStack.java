import java.util.Stack;

public class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int minStackTop;

    public MinStack() {
        this.stack = new int[1000];
        this.minStack = new int[1000];
        this.top = -1;
        this.minStackTop = -1;
    }

    public void push(int val) {
        if (top == 999) {
            throw new StackOverflowError("Stack is full");
        }

        stack[++top] = val;

        if (minStackTop == -1 || val <= minStack[minStackTop]) {
            minStack[++minStackTop] = val;
        }
    }

    public void pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }

        if (stack[top] == minStack[minStackTop]) {
            minStackTop--;
        }
        top--;
    }

    public int top() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public int getMin() {
        if (minStackTop == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack[minStackTop];
    }
}

class InnerMinStack {

    public Stack<Pair> stack;

    public InnerMinStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new Pair(value, value));
        } else {
            stack.push(new Pair(value, Math.min(value, stack.peek().minimum)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.pop().minimum;
    }

    private class Pair {
        public int value;
        public int minimum;

        public Pair(int value, int minimum) {
            this.value = value;
            this.minimum = minimum;
        }

    }

}


class OptimalMinStack {
    private Stack<Integer> stack;
    private int minimum = Integer.MAX_VALUE;

    public OptimalMinStack(){
        this.stack = new Stack<>();
    }

    public void push(int value){
        if (stack.isEmpty()) {
            this.minimum = value;
            stack.push(value);
        } else {
            if (value > this.minimum) {
                stack.push(value);
            }else {
                stack.push(2 * value - this.minimum);
                this.minimum = value;
            }
        }
    }

    public void pop(){
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.peek();
        stack.pop();

        if (top < this.minimum) {
            this.minimum = 2 * minimum - top;
            
        }

    }

    public int top(){
        if (stack.isEmpty()) {
            return -1;
        }

        if (this.minimum < stack.peek()) {
            return stack.peek();
        }

        return this.minimum;
    }
    public int getMin(){
        return this.minimum;
    } 
}