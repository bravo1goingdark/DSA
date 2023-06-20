public class recursion{
    public static void main(String[] args) {
        int[] ans = {1,2,3,4,5,6};
        System.out.println(BS(ans, 5, 0, ans.length - 1));
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
            b = b + a;
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
}