import java.util.Scanner;

public class invsqrt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 2;
        int x = in.nextInt();
        double y = Math.pow(10, (Math.log(1/x))/n);
        System.out.println(y);
    }
}
