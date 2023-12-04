//cutRod_DC
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int n = 14;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int maxSellValue = cutRod_DC(prices, n, memo);
        System.out.println("Max sell value is: " + maxSellValue);
    }

    public static int cutRod_DC(int[] prices, int n, int[] memo) {
        if (n <= 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, prices[i] + cutRod_DC(prices, n - i - 1, memo));
        }

        memo[n] = maxValue;
        return maxValue;
    }
}
