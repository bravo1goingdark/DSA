import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int left = 0;
        int right = 0;

        while (right < s.length && left < g.length) {
            if (s[right] >= g[left]) {
                left++;
            }
            right++;
        }

        return left;

    }
}
