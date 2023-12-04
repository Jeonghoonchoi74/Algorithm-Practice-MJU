//cutRod_DC
public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int n = 14;
        int result = cutRod_DC(prices, n);
        System.out.println("Max sell value is: " + result);
    }

    public static int cutRod_DC(int[] prices, int n) {
        if (n <= 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, prices[i] + cutRod_DC(prices, n - i - 1));
        }
        return maxValue;
    }
}
