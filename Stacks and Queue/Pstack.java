

public class Pstack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public Pstack(int size) {
        this.data = new int[size];
    }
    public Pstack() {
        this(DEFAULT_SIZE);
    }
    public boolean push(int input) throws Exception{
        if (isFull()) {
            throw new Exception("stack is full");
        }
        ptr++;
        data[ptr] = input;
        System.out.println("succesfully added");
        return true;

    }
    public int pop () throws Exception {
        if (isEmpty()) {
            throw new Exception("cannot pop from empty stack");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("cannot pop from empty stack");
        }
        return data[ptr];
    }
    private boolean isEmpty() {
        return ptr == -1;
    }
    public boolean isFull() {
        return ptr == data.length - 1;
    }
}