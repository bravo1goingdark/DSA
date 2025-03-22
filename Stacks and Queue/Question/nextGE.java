import java.util.Arrays;
import java.util.Stack;

public class nextGE {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(ngeOpt(new int[]{4,12,5,3,1,2,5,3,1,2,4,6})));
    }




    public static int[] ngeOpt(int[] arr){

        Stack<Integer> stack = new Stack<>();

        int[] nge = new int[arr.length];
        for (int index = arr.length - 1; index >= 0; index--) {
            
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nge[index] = -1;
                
            }else {
                nge[index] = stack.peek();
            }
            stack.push(arr[index]);
        }
        return nge;
    }


    

    // TC : O(N2) , SC : O(N)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];

        for (int index = 0; index < nums1.length; index++) {
            int elemIndex = getElementIndex(nums2, nums1[index]);
            int nextEle = getNextElement(nums2, elemIndex);

            if (nextEle != -1) {
                nge[index] = nextEle;
            }else {
                nge[index] = -1;
            }
            
        }
        return nge;
        
    }

    private static int getElementIndex(int[] arr , int ele){
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == ele) {
                return index;
            }
        }
        return -1;
    }

    private static int getNextElement(int[] arr ,int elemIndex){
        if (elemIndex < 0) {
            return -1;
        }
        int curr = arr[elemIndex];

        for (int index = elemIndex + 1; index < arr.length; index++) {
            if (arr[index] > curr) {
                return arr[index];
            }
        }
        return -1;

    }
}
