import java.util.Arrays;

// 1-->https://leetcode.com/problems/find-numbers-with-even-number-of-digits/  --------> findNum() , even() , countDigit()
// 2-->https://leetcode.com/problems/richest-customer-wealth/ -------> maxWealth()

public class QuestionLinear {
    public static void main(String[] args) {
        int[] arr = {555,901,482,1771};
        // System.out.println(FindMin(arr));
        // int[][] arr = {{1,2,3,4},{5,6,7},{8,9,10,11,12}};
        // int ans = FindMaxin2D(arr);
        // System.out.println(ans);
        // int body = maximumWealth(arr);
        // System.out.println(body);
        int out = findNum(arr);
        System.out.println(out);
    }
    static int FindMaxin2D(int[][] arr){
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]>max){
                    max = arr[row][col];
                }              
            }      
        }
        return max;

    }
    static int[] search2Darr(int[][] arr){
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == 12){
                    return new int[]{row , col};
                }              
            }      
        }
        return new int[] {-1,-1};
    }
    static int FindMin(int[] arr){
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(ans > arr[i]){
                ans = arr[i];
            }
        }
        return ans;
    }
    static int maximumWealth(int[][] accounts) { // use public instead of static in leetcode
        int ans = Integer.MIN_VALUE;
        
        for (int m = 0; m < accounts.length; m++) {
            int sum = 0;
            for (int n = 0; n < accounts[m].length; n++) {
                sum = sum + accounts[m][n];
            }
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;   
    }
    static int findNum(int[] nums){
        int count = 0;
        for (int num:nums) {
            if(even(num)){
                count++;
            }          
        }
        return count;
    }
    static boolean even(int arr){
        int noofdigit = countDigits(arr);
        return noofdigit % 2 == 0;

    }
    static int countDigits(int arr){
        int count = 0;
        while(arr > 0){
            count++;
            arr = arr/10;
        }
        return count;
    }
}
