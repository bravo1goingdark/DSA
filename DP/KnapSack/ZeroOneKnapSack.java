package KnapSack;

public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int[] weight = {3,2,4 , 8 , 9 , 10 , 30};
        int[] profit = {8,5,9 , 56 , 60 , 69 , 23};
        System.out.println(zeroOneKnapSackMemo(weight, profit, 14, weight.length));
    }

    public static int zeroOneKnapSack(int[] weight , int[] profit , int bagSize , int itemIndex){
        // base case
        if (bagSize == 0 || itemIndex == 0) {
            return 0;
        }

        if (weight[itemIndex - 1] > bagSize) {
            return zeroOneKnapSack(weight, profit, bagSize, itemIndex - 1);
        }
        
        // recursively skip the element
        int recurSkip = zeroOneKnapSack(weight, profit, bagSize, itemIndex - 1);
        int profitAtIndex = profit[itemIndex - 1];
        int weightAtIndex = bagSize - weight[itemIndex - 1];
        // calculate after including the element
        int recurInclude = profitAtIndex + zeroOneKnapSack(weight, profit, weightAtIndex, itemIndex - 1);
        
        // taking max of skipped element and including an element
        return Math.max(recurSkip , recurInclude );
    }

    public static int zeroOneKnapSackMemo(int[] weight , int[] profit , int bagSize , int itemIndex){
        // base case
        if (bagSize == 0 || itemIndex == 0) {
            return 0;
        }

        int[][] memo = new int[itemIndex][bagSize + 1];

        // checking if already calculated value is in the memo then simply returns it
        if (memo[itemIndex - 1][bagSize] != 0) {
            return memo[itemIndex - 1][bagSize];
        }

        if (weight[itemIndex - 1] > bagSize) {
            return zeroOneKnapSackMemo(weight, profit, bagSize, itemIndex - 1);
        }
        
        // recursively skip the element
        int recurSkip = zeroOneKnapSackMemo(weight, profit, bagSize, itemIndex - 1);
        int profitAtIndex = profit[itemIndex - 1];
        int weightAtIndex = bagSize - weight[itemIndex - 1];

        // calculate after including the element
        int recurInclude = profitAtIndex + zeroOneKnapSackMemo(weight, profit, weightAtIndex, itemIndex - 1);
        
        // storing max of skipped element and including an element
        memo[itemIndex - 1][bagSize] =  Math.max(recurSkip , recurInclude);
        return memo[itemIndex - 1][bagSize];
    }
}
