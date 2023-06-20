import java.util.Arrays;

// 1 --> https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
// 2 --> https://leetcode.com/problems/intersection-of-two-arrays/
public class recursionbasic{
    public static void main(String[] args) {
        int[] ans = {9,4,9,8,4};
        System.out.println(Arrays.toString(ans));
    }
    static int prevnum(int n){
        if(n <= 1){
            return n; // base condition --> a condition where recursion stops
        }
        System.out.println(n);
        return prevnum(n-1);
    }
    static int fiboiterative(int n){
        int a = 0;
        int b = 1;
        int count = 2;
        while(count <= n){
            int temp = b;
            b += a;
            a = temp;
            count++;
        }
        return b;
    }
    static int fiborecursive(int n){
        if (n < 2){
            return n;
        }
        // function is calling itself
        return fiborecursive(n - 1) + fiborecursive(n-2); // --> a function i.e able to break itself into smaller parts is known as rec-relation
    }
    // binary search using recursion
    static int BS(int[] arr, int target , int start , int end){
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (arr[mid] == target){
            return mid;
        }
        if (target > arr[mid]){
            return BS(arr, target, mid + 1, end);
        }
        return BS(arr, target, start, mid - 1);
    }
    static int iterativefact(int n){
        int ans = 1;
        for (int i = 1; i <=n ; i++) {
            int res = i;
            ans = ans * res;
        }
        return ans;
    }
    static int recursivefact(int n){
        if (n == 1){
            return 1;
        }
        return n * recursivefact(n-1);
    }
    static int iterativeSOD(int n){ //sum of individual digit
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans + rem;
            n /= 10;          
        }
        return ans;
    }
    static int recursiveSOD(int n){
        if (n == 0){
            return 0;
        }
        return n % 10 + recursiveSOD(n/10);
    }
    static int reverseDigit(int n){
        int ans = 0;
        while (n >0) {
            int rem = n % 10;
            n /= 10;
            ans = ans*10 + rem;
        }
        return ans;
    }
    static int RAD(int n){ // REVERSE A DIGIT
        int digits = (int)(Math.log10(n)) + 1;
        return add(n , digits);
    }
    static int add(int n , int digits){
        if(n % 10 == n){
            return n;
        }
        int rem = n % 10;
        return rem*(int)Math.pow(10, digits-1) + add(n/10, digits-1);
    }
    static int numberOfSteps(int num) {
        int count = 0;
        while (num > 0){
            if (num%2 == 0) {
                num /= 2;
                count++;
            }else {
                num -= 1;
                count++;
            }
        }
        return count;
    }
}