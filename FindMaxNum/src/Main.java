public class Main {

    public static int findMaximum(int[ ] A) {
        int i, max;
        max = A[0];
        for (i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[ ] 	intArray  =  {72, 60, 83, 47, 89, 95};
        int maximum;
        maximum =  findMaximum(intArray);
        System.out.println("최댓값 = " + maximum);
    }
}