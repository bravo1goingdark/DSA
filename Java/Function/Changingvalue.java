import java.util.Arrays;

public class Changingvalue {
    public static void main(String[] args) {
        // int[] arr = {1 , 2 ,3 ,4 ,5};
        // changearray(arr);
        // System.out.println(Arrays.toString(arr));

        for (int i = 0 ; i <=5 ; i++) {
            System.out.println(i);
        }
        // System.out.println(i); // loop scope

    }
    static void changearray(int[] arr) {
        arr[0] = 100;
        arr[1] = 99;
    }
}
