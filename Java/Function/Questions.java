import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // boolean ans = isArmstrong(n);
        // System.out.println(ans);
        // for(int i = 100 ; i <1000 ; i++) {
        //     if(isPalindrome(i)){
        //         System.out.println(i);
        //     }
        // }
        boolean bravo = isPalindrome(121);
        System.out.println(bravo);
        // isEligibletoVote(n);

    }
    static boolean isPythagoreanTriplet() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int ans = a*a + b*b;
        return ans == c*c;
    }
    static void isEligibletoVote(int n){
        if (n >=18){
            System.out.println("Person is elible to vote");
        }else {
            System.out.println("person is not elible to vote");
        }

    }
    static int sum(int n){
        int sum = 0;
        for(int i = 1; i<=n ; i++){
            sum = sum +i;
        }
        return sum;

    }
    static int Factorial(int n) {
        int fact = 1;
        for(int i = 1 ; i <=n ; i++){
            fact = fact*i;
        }
        return fact;

    }
    static boolean isPalindrome(int n) {
        int original = n;
        int ans = 0;
        while (n >0){
            int rem = n %10;
            n /= 10;
            ans = ans*10 + rem;
        }
        return ans == original;
    }
    static boolean isArmstrong(int n) {
        int sum = 0;
        int original = n;
        while(n > 0){
            int rem = n%10;
            n /=10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }
    static boolean isPrime(int n) {
        if (n <= 1){
            return false;
        }
        int c =2;
        while(c*c <= n){
            if ( n % c == 0){
                return false;
            }
            c++;
        }
        return c*c > n;

    }
    
}
