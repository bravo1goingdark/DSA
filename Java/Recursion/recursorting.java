import java.util.Arrays;

public class recursorting {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionrec(arr, arr.length, 0 , 0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubblerec(int[] arr , int lastindex , int currentindex){
        if(lastindex == 0){
            return;
        }
        if(currentindex < lastindex){
            if(arr[currentindex] > arr[currentindex + 1]){
                int temp = arr[currentindex];
                arr[currentindex] = arr[currentindex+1];
                arr[currentindex+1] = temp; 
            }
            bubblerec(arr, lastindex, currentindex + 1);
        }else {
            bubblerec(arr, lastindex - 1, 0);
        }
    }
    static void selectionrec(int[] arr , int lastindex , int currentindex , int max){
        if(lastindex == 0){
            return;
        }
        if(currentindex < lastindex){
            if(arr[currentindex] > arr[max]){
                selectionrec(arr, lastindex, currentindex + 1, currentindex);
            }else {
                selectionrec(arr, lastindex, currentindex + 1, max);
            }
        }else {
            int temp = arr[max];
            arr[max] = arr[lastindex - 1];
            arr[lastindex - 1] = temp; 
            selectionrec(arr, lastindex - 1, 0, 0);
        }
    }
}
