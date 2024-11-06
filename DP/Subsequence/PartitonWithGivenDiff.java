package Subsequence;

public class PartitonWithGivenDiff {
    public static int MOD = (int) (1e9 + 7);

    public static int countPartitions(int d, int[] arr) {
        int totalSum = getTotalSum(arr);
        int target = totalSum - d;
        
        if (target < 0 || !isEven(target)) {
            return 0;
        }

        return countSubsetWithSumKSpaceOpt(target / 2, arr);
    }
    
    private static int countSubsetWithSumKSpaceOpt(int target, int[] arr) {
        int[] prev = new int[target + 1];
        
        prev[0] = 1; 
        
        if (arr[0] == 0) {
            prev[0] = 2; 
        } else if (arr[0] <= target) {
            prev[arr[0]] = 1; 
        }

        for (int index = 1; index < arr.length; index++) {
            int[] curr = new int[target + 1];
            for (int sum = 0; sum <= target; sum++) {
                int notPick = prev[sum];
                int pick = 0;
                if (arr[index] <= sum) {
                    pick = prev[sum - arr[index]];
                }
                curr[sum] = (pick + notPick) % MOD;
            }
            prev = curr; 
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
