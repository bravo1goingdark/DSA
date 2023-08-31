import java.util.Arrays;

public class mergesort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{9,8,7,6,5})));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] first = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(first , second);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] newarr = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                newarr[k] = first[i];
                i++;
            } else {
                newarr[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            newarr[k] = first[i];
            i++;
            k++;
        }

         while (j < second.length) {
            newarr[k] = second[j];
            j++;
            k++;
        }

        return newarr;

    }
}