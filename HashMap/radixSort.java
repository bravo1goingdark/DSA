import java.util.Arrays;

public class radixSort {

    public static void main(String[] args) {
        int[] array = {100 , 300 , 200 , 1000 , 12000};
        System.out.println("Original array: " + Arrays.toString(array));

        int[] sortedArray = radixsort(array);

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
    public static int[] radixsort(int[] arr) {

        // Find the maximum element to determine the number of digits
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Perform counting sort for every digit, starting from the least significant digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
        return arr;
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];

        // creating count array to store frequency of each element
        int[] count = new int[10];
         for (int i = 0; i < array.length; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }
        // Modify the count array to store the actual position of each element in the sorted array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary array to store the sorted elements and build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);

    }

}
