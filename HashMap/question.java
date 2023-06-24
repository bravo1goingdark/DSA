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
    public int singleNumber(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
        
    }
    public int singlenumber(int[] nums) { // more faster than above solution
        int result = 0;
        
        // XOR all numbers in the array
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
    public int romanToInt(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = map.get(arr[0]);
        for (int i = 1; i < arr.length ; i++) {
            int currentValue = map.get(arr[i]);
            int previousValue = map.get(arr[i - 1]);
            if (currentValue > previousValue)  {
                ans += currentValue - 2*previousValue;
            }
            else {
                ans += currentValue;
            }
        }
        return ans;

    }
}
