package Question;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
      
        while (right < fruits.length) {
          if (map.containsKey(fruits[right])) {
            map.put(fruits[right], map.get(fruits[right]) + 1);
          } else {
            map.put(fruits[right], 1);
          }
      
          if (map.size() > 2) {
            int leftFruit = fruits[left];
            map.put(leftFruit, map.get(leftFruit) - 1);

            if (map.get(leftFruit) == 0) {
               map.remove(leftFruit);
            }
            left++;
            
          }
      
          max = Math.max(max, right - left + 1);
      
          right++;
        }
      
        return max;
      }
}
