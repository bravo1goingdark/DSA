
package Question;

public class maxPointCard {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int max = 0;
        int rIndex = cardPoints.length - 1;

        for (int index = 0; index < k; index++) {
            lsum += cardPoints[index];
        }
        max = lsum;

        for (int index = k - 1; index >= 0; index--) {
            lsum -= cardPoints[index];
            rsum += cardPoints[rIndex];
            rIndex--;
            max = Math.max(max, lsum + rsum);
        }

        return max;

    }
}