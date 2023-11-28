// Description: Merge Sort Algorithm
public class Main {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m ,r);
        }
    }

    //merge two arrays of arr[]
    public static void merge(int[] arr, int l, int m, int r) {
        //find sizes of two arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l+i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m+1+j];
        }

        //merge the temp arrays
        //initial indexes of first and second arrays
        int i = 0, j = 0;

        //initial index of merged subarray
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { //if L[i] is smaller than or equal to R[j]
                arr[k] = L[i];
                i++;
            } else { //if L[i] is greater than R[j]
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        //create an array
        int[] arr = {12, 11, 13, 5, 6, 7, 1, 2, 3, 4};
        //merge sort
        mergeSort(arr, 0, arr.length-1);
        //print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}