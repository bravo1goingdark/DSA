public class bit {
    public static void main(String[] args) {
        System.out.println(toDecimal(toBinary(1300 ^ 7)));
    }
    public static String toBinary(int num){
        String res = "";
        while (num != 1) {
            res += num % 2;
            num /= 2;
        }
        res += 1;
        return reverse(res);
    }
    public static int toDecimal(String str){
        int start = 0;
        int end = str.length() - 1;
        int res = 0;
        while (end >= 0) {
            if (str.charAt(end) == '1') {
                res += Math.pow(2,start);
            }
            start++;
            end--;
        }
        return res;
    }
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        int start = 0;
        int end = sb.length() - 1;

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        return sb.toString();
    }
}