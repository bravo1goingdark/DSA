import java.util.Arrays;

public class countSort {
    public static void main(String[] args) {
        int[] array = countsort(new int[]{4, 2, 2, 8, 3, 3, 1});
        System.out.println(Arrays.toString(array));
    }

    public static int[] countsort(int[] arr) {
        if (arr == null || arr.length ==0) {
            return arr;
        }

        // find maximum element in array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // creating count array to store frequency of each element
        int[] count = new int[max + 1];

        // Store the count of each element in the count array
        for (int i = 0; i < arr.length ; i++) {
            count[arr[i]]++; 
        }

        // Modify the count array to store the actual position of each element in the sorted array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
        }

        // Create a temporary array to store the sorted elements
        int[] sortedArray = new int[arr.length];

        // Build the sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return sortedArray;
    }
}
