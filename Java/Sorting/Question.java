// 1 --> https://leetcode.com/problems/missing-number/  amazon
// 2 --> https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/  google (uses list)
// 3 --> https://leetcode.com/problems/find-the-duplicate-number/  amazon 
// 4 --> https://leetcode.com/problems/find-all-duplicates-in-an-array/  microsoft (uses list)
// 5 --> https://leetcode.com/problems/set-mismatch/description/  (findErrorNums)  
// 6 --> https://leetcode.com/problems/first-missing-positive/
public class Question {
    public static void main(String[] args) {
        int[] arr = {0,1};
        int ans = missingNumber(arr);
        System.out.println(ans);
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int index = nums[i] - 1 ; // here index = value - 1 beacause the range is starting from (1 , n) not (0,n)
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[index]){
                swap(nums , i , index);
            }else{
                i++;
            }
        }// case 1
        for (int index = 0 ; index < nums.length; index++) {
            if(nums[index] != index + 1){
                return index+1;
            }
        }// case 2
        return nums.length + 1;
    }    
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int index = nums[i] - 1 ; // here index = value - 1 beacause the range is starting from (1 , n) not (0,n)
            if(nums[i] != nums[index]){
                swap(nums , i , index);
            }else{
                i++;
            }
        }// case 1
        for (int index = 0 ; index < nums.length; index++) {
            if(nums[index] != index + 1){
                return new int[] {nums[index] , index+1};
            }
        }// case 2
        // return nums.length;

        return new int[]{-1,-1}; 
    }
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int index = nums[i] - 1 ; // here index = value - 1 beacause the range is starting from (1 , n) not (0,n)
            if(nums[i] != nums[index]){
                swap(nums , i , index);
            }else{
                i++;
            }
        }// case 1
        for (int index = 0 ; index < nums.length; index++) {
            if(nums[index] != index + 1){
                return nums[index];
            }
        }// case 2
        return nums.length;
    }

    static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int index = nums[i] ; // here index != value - 1 beacause the range is starting from (0 , n) not (1,n)
            if(nums[i] < nums.length &&  nums[i] != nums[index]){
                swap(nums , i , index);
            }else{
                i++;
            }
        }// case 1
        for (int index = 0 ; index < nums.length; index++) {
            if(nums[index] != index){
                return index;
            }
        }// case 2
        return nums.length;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
}
