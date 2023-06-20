// 1 --> https://leetcode.com/problems/flipping-an-image/description/

public class Bit_manipulation{
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] ans = flipAndInvertImage(arr);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
        }
    }
    // Given a number n find if it is odd or not
    static boolean isodd(int number) {
        return (number & 1) == 1;
    }
    // given an array off numbers and in that array every number appears twice and only one number appear once. Find that number
    static int appearonce(int[] arr){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num^arr[i];
        }
        return num;
    }
    static int ith(int n , int target){
        int ans = n & (1 << (target-1));
        return ans;
    }
    // find the nth magic number (amazon)
    static int magicnumber(int n){
        int ans = 0;
        int base = 5;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        return ans;
    }
    // find number of digit in base b
    static int noofdigit(int n , int base){
        int ans = (int) (Math.log(n)/Math.log(base)) + 1;
        return ans;
    }
    // find power of any given base without using Math.Pow()
    static int pow(int base, int power){
        int ans = 1;
        while(power > 0){
            if((power & 1) == 1){
                ans = ans*base;
            } 
            base = base*base;
            power = power >> 1;
        }
        return ans;
    }
    static int xor(int a){
        int num = 0;
        for (int i = 0; i < a; i++) {
            num ^= i;
        }
        return num;
    }
    // flip an image 
    static int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int c = 0; c < (image[0].length + 1) / 2; c++) {
                int temp = row[c] ^ 1;
                row[c] = row[image[0].length - 1 - c] ^ 1;
                row[image[0].length - 1 - c] = temp;
            }
        }       
        return image;
    }

}