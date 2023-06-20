import java.util.Arrays;

// 1 --> https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// 2 --> https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// 3 --> https://leetcode.com/problems/sort-an-array/
public class interviewques {
    public static void main(String[] args) {
        int[] ans = {1,2,3};
        String s = "";
        for (int i = 0; i <= ans.length - 1; i++) {
            s = Integer.toString(ans[i]);
        }
        System.out.println(s);
    }
    static int numRollsToTarget(int n, int k, int target) { // third case failed (30,30,500)
        int start = n - 1;
        if (start == 0) {
            start = 1;
        }
        int end = k;
        int count = 0;
        while (start != k && end != start) {
            int res = start + end;
            if( res == target){
                count += 1;
            }
            start++;
            end--;   
        }
        return count + 1;

    }
    static int[] sortArray(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        int mid = nums.length / 2;
        int[] firstarr = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] secondarr = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return merged(firstarr , secondarr);
    }
    static int[] merged(int[] firstarr, int[] secondarr) {
        int[] newarr = new int[firstarr.length + secondarr.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < firstarr.length && j < secondarr.length) {
            if (firstarr[i] < secondarr[j]) {
                newarr[k] = firstarr[i];
                i++;
            } else {
                newarr[k] = secondarr[j];
                j++;
            }
            k++;
        }
        while (i < firstarr.length) {
            newarr[k] = firstarr[i];
            i++;
            k++;
        }
        while (j < secondarr.length) {
            newarr[k] = secondarr[j];
            j++;
            k++;
        }
        return newarr;
    }
}

