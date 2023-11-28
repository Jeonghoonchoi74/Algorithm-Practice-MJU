// Description: Find Maximum and Minimum with divide and conquer
public class Main {
//I want to find maximum and minimum with divide and conquer with 16 length array with random number
public static int[] findMaxMin(int[] arr, int start, int end) {
    int[] result = new int[2];
    if (start == end) {
        result[0] = arr[start];
        result[1] = arr[start];
        return result;
    } else if (start == end - 1) {
        if (arr[start] > arr[end]) {
            result[0] = arr[start];
            result[1] = arr[end];
        } else {
            result[0] = arr[end];
            result[1] = arr[start];
        }
        return result;
    } else {
        int mid = (start + end) / 2;
        int[] left = findMaxMin(arr, start, mid);
        int[] right = findMaxMin(arr, mid + 1, end);
        if (left[0] > right[0]) {
            result[0] = left[0];
        } else {
            result[0] = right[0];
        }
        if (left[1] < right[1]) {
            result[1] = left[1];
        } else {
            result[1] = right[1];
        }
        return result;
    }
}
    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        int[] result = findMaxMin(arr, 0, arr.length - 1);
        System.out.println("Maximum: " + result[0]);
        System.out.println("Minimum: " + result[1]);
    }


}