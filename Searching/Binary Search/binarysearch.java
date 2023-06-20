public class binarysearch{
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1}; //increasing order
        // int ans = binarysearch1D(arr, 3);
        int ans = orderAgnosticBS(arr, 10);
        System.out.println(ans);
    }
    static int binarysearch1D(int[] arr , int target){
        int start = 0;
        int end = arr.length - 1;
        while (end >= start){
            // int mid = (start+end) /2; //mid may increase integer limit in java using this formula
            int mid = start + (end - start)/2;
            if (target > arr[mid]){
                start = mid + 1;
            }else if (target < arr[mid]){
                end = mid -1;
            }
            else{
                return mid;
            }
        }
        return -1 ;
    }
    static int orderAgnosticBS(int[] arr , int target){ //if it is not known that array is in ascending or descending
        int start = 0;
        int end = arr.length -1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end){
            int mid = start + (end - start)/2;
            if (target == arr[mid]){
                return mid;
            }
            if (isAsc){
                if(target > arr[mid]){
                    start = mid +1;
                }
                else {
                    end = mid - 1;
                }
            }else {
                if (target < arr[mid]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}