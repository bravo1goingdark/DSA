import java.util.Arrays;
import java.util.HashMap;

public class question {
    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(ans));
    }
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];

            if (map.containsKey(left)) {
                return new int[] {map.get(left) , i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
