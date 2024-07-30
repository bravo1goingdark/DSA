package Question;

public class bitFlip {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        return count(ans);

    }
    private static int count(int num){
        int count = 0;

        while (num != 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}
