//Selection Sort
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0, 99, 88, 77, 66, 55, 44, 33, 22, 11, 10, 9, 8, 7, 6};
        int [] result = SelectionSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] SelectionSort(int[] arr){
        int min = 0;
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}