public class recursionarr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int ans = lsrecursiveindex(arr ,7,0);
        System.out.println(ans);
    }
    static boolean isSortediterative(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]){
                i++;        
            }else {
                return false;
            }
        }
        return true;
    }
    static boolean isSortedrecursive(int[] arr , int index){
        if(index == arr.length -1){
            return true;
        }
        return arr[index] < arr[index+1] && isSortedrecursive(arr, index + 1);

    }
    static boolean lsearchrecursive(int[] arr , int target , int index){
        if(arr[index] == arr.length){
            return false;
        }
        return arr[index] == target || lsearchrecursive(arr, target, index+1);
    }
    static int lsrecursiveindex(int[] arr , int target , int index){
        if(arr[index] == arr.length ){
            return -1;
        }
        if(arr[index] == target){
            return index;
        } else{
            return lsrecursiveindex(arr, target, index+1);
        }
    }
}
