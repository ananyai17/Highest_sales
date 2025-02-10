import java.util.Arrays;  // Import statement for Arrays

public class INVERSION {
    public static void main(String[] args) {
        int[] arr = {30, 45, 25, 60, 20};
        System.out.println("The inversion count is " + countInversions(arr));
    }

    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int inversions = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            inversions += mergeSort(arr, low, mid);
            inversions += mergeSort(arr, mid + 1, high);
            inversions += merge(arr, low, mid, high);
        }
        return inversions;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int i = 0, j = 0, k = low, inversions = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversions += left.length - i;
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        return inversions;
    }
}