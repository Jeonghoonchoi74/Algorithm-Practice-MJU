//Quick Sort
public class Main {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 6, 4,10,99,87,56,34,19 };
        int[] result = quickSort(arr, 0, arr.length - 1);

        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

        return arr;
    }

    // Partition the array by setting the pivot to the rightmost element
    // and then moving all elements smaller than the pivot to the left of it
    // and all elements larger than the pivot to the right of it
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }
}
