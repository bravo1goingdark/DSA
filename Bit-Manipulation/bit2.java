import java.util.Arrays;

public class bit2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(swap(12, 13)));
        System.out.println(isIthBitSet(13, 1));
        System.out.println(setIthBit(13, 5));
        System.out.println(clearIthBit(13, 2));
        System.out.println(toogleIthBit(13, 1));
    }
    public static int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a,b};
    }
    public static boolean isIthBitSet(int num , int bit){
        // (num >> bit) -> the right shift operator shift the binary number by bit 
        // then doing & with 1 gives if the ith bit is set or not
        // 13 -> 1 1 0 1 >> 2 -> 0 0 1 1
        // 0 0 1 1 & 1 -> as 1 == 1 will result in true
        return ((num >> bit) & 1) == 1;
    }

    public static int setIthBit(int num , int bit){
        // check if the ith bit is already set
        if (isIthBitSet(num, bit)) {
            return num;
        }
        int shiftLeft = 1 << bit; // left shift by bit
        int setBit = num | shiftLeft; // or the left shift result with the number
        return setBit;
    }
    public static int clearIthBit(int num,int bit){
        int compLeftBit = ~(1 << bit);
        return num & compLeftBit;
    }
    public static int toogleIthBit(int num,int bit){
        return num ^ (1 << bit);
    }
}