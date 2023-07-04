// 1 --> https://leetcode.com/problems/valid-perfect-square/
// 2 --> https://leetcode.com/problems/find-smallest-letter-greater-than-target/
// 3 --> https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 4 --> https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
// 5 --> https://leetcode.com/problems/peak-index-in-a-mountain-array/
// 6 --> https://leetcode.com/problems/find-peak-element/   --> same ans as of question 5
public class Question {
    // public static void main(String[] args) {
    //     // boolean ans = perfectsquare(808201);
    //     int[] arr = {4,5,6,7,0,1,2};
    //     System.out.println(search(arr , 0));
    //     // char[] letters = {'c' , 'f' , 'j'};
    //     // char ans = nextGreatestLetter(letters, 'c');
        
    //     // int[] read = {5,7,7,8,8,10};
    //     // int target = 7;
    //     // int[] hollow = searchRange(read, target);
    //     // System.out.println(Arrays.toString(hollow));
    // }
    
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarysearch1D(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarysearch1D(nums, target, 0, pivot - 1);
        }

        return binarysearch1D(nums, target, pivot + 1, nums.length - 1);
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if (mid > end && arr[mid] > arr[mid+1]){
                return mid;
            }if(mid < start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid+1]){
                end = mid;
            }else {
                start = mid +1;
            }
        }
        return start;
    }
    static int InfiniteArray(int[] arr , int target){
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newstart = end + 1;
            end = end +(end - start + 1);
            start = newstart;
        }return binarysearch1D(arr, target, start, end);
    }
    static int binarysearch1D(int[] arr , int target , int start , int end){
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
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1 , -1};
        ans[0] = search(nums,target, true);
        ans[1] = search(nums, target, false);

        return ans;
    }
    static int search(int[] nums , int target , boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]) {
                start = mid + 1;
            }
            else {
                //potential answer found
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(target < letters[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
        
    }
    static int floorofnum(int[] arr , int target){
        if(target > arr[arr.length -1]){
            return -1;
        }
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if (target > arr[mid]){
                start = mid + 1;
            }
            else if (target < arr[mid]) {
                end = mid -1;
            }
            else {
                return mid;
            }
        }
        return end;
    }
    static int ceilingofnum(int[] arr , int target){
        if(target > arr[arr.length -1]){
            return -1;
        }

        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if (target > arr[mid]){
                start = mid + 1;
            }
            else if (target < arr[mid]) {
                end = mid -1;
            }
            else {
                return mid;
            }
        }
        return start;
    }
    static boolean perfectsquare(int x) {
        double y = Math.pow(10, Math.log10(x)/2);
        
        if(y*y == x && y % 1 == 0){
            return true;
        }
        return false;
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newarr = mergeArrays(nums1, nums2);
        int start = 0;
        int end = newarr.length - 1;
        int mid = start + (end - start) / 2;

        if (end % 2 == 0) {
            return newarr[mid];
        } 
        return (newarr[mid] + newarr[mid + 1]) / 2;
    }

    static int[] mergeArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];

        int i = 0; // Index for nums1
        int j = 0; // Index for nums2
        int k = 0; // Index for the merged array

        // Compare elements from both arrays and add them to the merged array in the correct order
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        // Add any remaining elements from nums1, if there are any
        while (i < m) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        // Add any remaining elements from nums2, if there are any
        while (j < n) {
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }
    
}