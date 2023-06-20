// dynamic stack ---> array that never will be full
public class Dstack extends Pstack{
    public Dstack() {
        super();
    }
    public Dstack(int size) {
        super(size);
    }
    @Override
    public boolean push(int item) throws Exception {
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(item);
    }
}
