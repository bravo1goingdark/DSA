import java.util.Arrays;

public class Question {
    public static void main(String[] args) {
        //swap question --> swap()
        //maxValue in a array question --> maxVal()
        //maxValue in range question --> maxValRange()
        //reverse an array --> reversearr()
        int[] arr = {1,2,3,4,5};
        // swap(arr , 1 , 2);
        // System.out.println(maxValRange(arr , 0 , 1));
        reversearr(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reversearr(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(end > start || end == start){  //no need to add end==start , since end will never exceed start
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    static int maxValRange(int[] arr , int start , int end){
        int max = arr[start];
        for(int i = start; i<= end ; i++ ){
            if(arr[i] >max ){
                max = arr[i];
            }
        }
        return max;
    }
    static int maxVal(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void swap(int[] arr , int index1 , int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;  
    }
}