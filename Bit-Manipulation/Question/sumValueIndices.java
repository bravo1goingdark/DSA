// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/submissions/1338218846/

package Question;
import java.util.List;
public class sumValueIndices {
    public static void main(String[] args) {
        System.out.println(count(2, 1));
    }
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int index = 0; index < nums.size(); index++) {
            if (count(index, k)) {
                sum += nums.get(index);
            }
        }
        return sum;
    }
    private static boolean count(int num , int k){
        int count = 0;

        while (num != 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count == k;
    }
}
