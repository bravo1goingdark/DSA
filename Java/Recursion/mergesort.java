import java.util.Arrays;

public class mergesort {
    public static void main(String[] args) {
       int[] arr = {5,3,2,1};
       
       System.out.println(Arrays.toString(mergeSort(arr))); 
    }
    static int[] mergeSort(int[] arr){ // does not change original array
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] firstarr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] secondarr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(firstarr ,secondarr);
    }

    static int[] merge(int[] firstarr, int[] secondarr) {
        int[] newarr = new int[firstarr.length+secondarr.length];
        int i = 0; // pointer for firstarr
        int j = 0; // pointer for secondarr
        int k = 0; // pointer for newarr
        while(i < firstarr.length && j < secondarr.length){
            if (firstarr[i] < secondarr[j]) {
                newarr[k] = firstarr[i];
                i++; 
            }else{
                newarr[k] = secondarr[j];
                j++;
            }
            k++;
        }
        // it may be possible that length of firstarr != length of secondarr
        // copy the remaining element in newrr
        while (i < firstarr.length) {
            newarr[k] = firstarr[i];
            i++;
            k++;
        }
        while (j < secondarr.length) {
            newarr[k] = secondarr[j];
            j++;
            k++;
        }
        return newarr;
    }
    static void InPlacemergeSort(int[] arr , int start , int end){ // does not change original array
        if(end - start == 1){
            return;
        }
        int mid = start + (end - start)/ 2;
        InPlacemergeSort(arr, start, mid);
        InPlacemergeSort(arr, mid, end);
        mergeInPlace(arr , start , mid , end);
    }

    static void mergeInPlace(int[] arr , int start , int mid , int end) {
        int[] newarr = new int[end - start];
        int i = start; // pointer for firstarr
        int j = mid; // pointer for secondarr
        int k = 0; // pointer for newarr
        while(i < mid && j < end){
            if (arr[i] < arr[j]) {
                newarr[k] = arr[i];
                i++; 
            }else{
                newarr[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that length of firstarr != length of secondarr
        // copy the remaining element in newrr
        while (i < mid) {
            newarr[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            newarr[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < newarr.length; l++) {
            arr[start+l] = newarr[l] ;
        }
    }
}