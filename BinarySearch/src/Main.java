//binary search tree
public class Main {
    public static void binarySearch(int[] A, int first, int last, int x){
        int mid = (first + last)/2;
        while(first <= last){
            if(A[mid] < x){
                first = mid + 1;
            }else if(A[mid] == x){
                System.out.println("Element is found at index: " + mid);
                System.out.println("The element is: " + A[mid]);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if(first > last){
            System.out.println("Element is not found!");
        }
    }
    public static void main(String[] args) {
        int[] A = new int[]{10, 20, 30, 40, 50};
        int x = 30; //the element we are looking for
        int last = A.length - 1;
        binarySearch(A, 0, last, x);
    }
}