package Question;

import java.util.ArrayList;
import java.util.List;

public class powerSet {
    public static void main(String[] args) {
        System.out.println(set(new int[]{1,2,3}));
    }
    public static List<List<Integer>> set(int[] nums){
        List<List<Integer>> set = new ArrayList<>();
        for (int f = 0; f < (1 << nums.length); f++) {
            List<Integer> curr = new ArrayList<>();
            for (int s = 0; s < nums.length; s++) {
                if ((f & (1 << s)) != 0) {
                    curr.add(nums[s]);
                }
            }
            set.add(curr);
        }

        return set;
    }
}
