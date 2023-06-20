import java.util.Arrays;

public class PassinginFunction {
    public static void main(String[] args) {
        int[] marks = {10 ,20 ,30 ,40};
        System.out.println(Arrays.toString(marks));
        changeNums(marks);
        System.out.println(Arrays.toString(marks));
        
    }
    static void changeNums(int[] nums) {
        nums[0] = 50 ;

    }
}
