package Question;

public class RevereseBit {
    public static void main(String[] args) {
        System.out.println(reverseBits(11101111));
    }
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;       // Shift result left by 1 bit
            result |= (n & 1);  // Get the least significant bit of n and add it to result
            n >>= 1;            // Shift n right by 1 bit
        }
        return result;
    }
}
