import java.util.Arrays;

public class cyclicsort {
    public static void main(String[] args) {
        int[] arr = {4,1,3,4,2};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycle(int[] arr){ // only applicable for positive natural number i.e (0 , n-1) or (1,n)
        int i = 0;
        while(i < arr.length){
            int index = arr[i] -1;
            if(arr[i] != arr[index]){
                swap(arr , i , index);
            }else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}