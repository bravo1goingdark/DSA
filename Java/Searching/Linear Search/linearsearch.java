import java.util.Scanner;

public class linearsearch{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6};
        int start = 0;
        int end = arr.length-1;
        int n = in.nextInt();
        for (int i = start; i <= end; i++) {
            if(arr[i] == n){
                System.out.println(n + " "+ "is located at" +" "+ i);
            }
        }
    }
}