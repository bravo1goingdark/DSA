import java.util.Scanner;

public class sum{
    public static void main(String[] args) {
        // sum2();
        // greetings();
        // int ans = sum3(100 , 200);
        String buddy = mygreet("Ashutosh kumar");
        System.out.println(buddy);
    }
    static String mygreet(String name){
        String ans = "hello" + name;
        return ans;
    }
    static int sum3(int a , int b){
        int sum = a+b;
        return sum;
    }
    static void sum2() {
        Scanner in = new Scanner(System.in);
        int num1 , num2 , sum;
        num1 = in.nextInt();
        num2 = in.nextInt();
        sum = num1 + num2 ;
        System.out.println(sum);
    }
    static void greetings() {
        System.out.println("Good Morning");
    }
}