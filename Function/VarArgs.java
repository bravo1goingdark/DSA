import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(2,3,4,5,6,7,8,9);
        multiple(10, 30, "Ashutosh" , "Kumar" , "Akash" , "Mayank");
    }
    static void multiple(int a , int b , String ...v){
        System.out.println(Arrays.toString(v));
    }

    static void fun(int ...a) {
        System.out.println(Arrays.toString(a));
    }
}
