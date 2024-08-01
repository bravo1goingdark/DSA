package Question;

public class maxConsecIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int noOfZero = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                noOfZero++;
            }

            if (noOfZero > k) {
                if (nums[left] == 0) {
                    noOfZero--;
                }
                left++;
            }
            if (noOfZero <= k) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }

        return max;
    }
}
