// Kadane's algorithm is a greedy/dynamic programming algorithm 
// that can be used on array problems to bring the time complexity down to O(n)
// It is used to calculate the maximum sum subarray ending at a particular position.

public class kadanes {
    public static void main(String[] args) {
        
    }

    public static int bruteforce(int[] nums){
        int maxsum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currsum = 0;
            for (int j = i; j < nums.length; j++) {
                currsum += nums[j];
                maxsum = Math.max(maxsum, currsum);
            }
        }
        return maxsum;
    }

    public int kadane(int[] nums){
        int maxsum = nums[0];
        int currsum = 0;

        for (int num : nums) {
            currsum = Math.max(currsum, 0);
            currsum += num;
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }

}