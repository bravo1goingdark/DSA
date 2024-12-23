import java.util.ArrayList;

public class tryjava {
    public static void main(String[] args) {
        // printrecur(5);
        System.out.println(printPermRet("", "abc"));       
    }

    public static void printrecur(int num){
        if (num == 0) {
            return;
        }
        System.out.println(num);
        printrecur(num - 1);
        System.out.println(num);
    }
    public static int sod(int num){
        if (num == 0) {
            return 0;
        }
        return num % 10 + sod(num/10);
    }
    public static int pod(int num){
        if (num == 0) {
            return 1;
        }
        return num % 10 * pod(num/10);
    }

    public static int countsteps(int num){
        return helper(num , 0);
    }

    private static int helper(int num, int steps) {
        if (num == 0) {
            return steps;
        }

        if (num % 2 == 0) {
            return helper(num/10, steps+1);
        }
        return helper(num-1, steps+1);
    }

    public static int search(int[] arr,int target , int index){
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return search(arr, target, index+1);
    }
    public static ArrayList<Integer> findIndex(int[] arr , int target , int index){
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowFuncCalls = findIndex(arr, target, index + 1);
        list.addAll(ansFromBelowFuncCalls);
        return list;
    } 
    public int searchRotatedArr(int[] arr , int target , int start , int end){
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (target > arr[start] && target < arr[end]) {
                return searchRotatedArr(arr, target, start, mid - 1);
            }else {
                return searchRotatedArr(arr, target, mid + 1, end);

            }
        }
        if (target >= arr[mid] && target <= arr[end]) {
            return searchRotatedArr(arr, target, mid + 1, end);
        }
        return searchRotatedArr(arr, target, start, mid - 1);
    }

    public static void skip(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        } else{
            skip(p + ch, up.substring(1));
        }
    }

    public static String skipChar(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            return skipChar(up.substring(1));
        } else{
            return ch + skipChar(up.substring(1));
        }
    }
    public static String skipApple(String up){

        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        } else{
            return ch + skipApple(up.substring(1));
        }
    }

    public static void printPerm(String permute , String org){
        if (org.isEmpty()) {
            System.out.println(permute);
            return;
        }
        char ch = org.charAt(0);
        printPerm(ch + permute, org.substring(1));
        printPerm(permute, org.substring(1));
    }
    public static ArrayList<ArrayList<String>> printPermRet(String permute , String org){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        if (org.isEmpty()) {
            ArrayList<String> newlist = new ArrayList<>();
            newlist.add(permute);
            list.add(newlist);
            return list;
        }
        char ch = org.charAt(0);
        ArrayList<ArrayList<String>> left =  printPermRet(ch + permute, org.substring(1));
        ArrayList<ArrayList<String>> right =  printPermRet(permute, org.substring(1));
        left.addAll(right);
        return left;
    }
}
