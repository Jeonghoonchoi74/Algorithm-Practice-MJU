// cutRod_DP
public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int n = 14;
        int result = cutRod_DP(prices, n);
        System.out.println(result);
    }

    public static int cutRod_DP(int[] p, int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];
    }
}