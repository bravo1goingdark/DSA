public class Cirqueue {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    protected int size = 0;

    public Cirqueue(int size) {
        this.data = new int[size];
    }
    public Cirqueue() {
        this(DEFAULT_SIZE);
    }
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end %= data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        int removed = data[front];
        front %= data.length;
        size--;
        return removed;
    }
    public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        return data[front];
    }
    public void display() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        int i = front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while(i != end);
        System.out.print("END");
    }
    private boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == data.length;
    }
}
