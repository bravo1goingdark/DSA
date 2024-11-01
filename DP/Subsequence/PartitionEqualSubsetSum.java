package Subsequence;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        boolean isEven = isEven(getTotalSum(nums));

        return !isEven ? false : subsetSumEqualKSpaceOpt(nums.length, getTotalSum(nums) / 2, nums);
    }

    private static boolean subsetSumEqualKSpaceOpt(int size, int target, int[] arr) {
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        prev[0] = true;
        curr[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = (j >= arr[i]) ? prev[j - arr[i]] : false;
                curr[j] = notTake || take;
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[target];
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int getTotalSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
