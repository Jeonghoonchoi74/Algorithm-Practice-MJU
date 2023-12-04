// Coin Change Problem using Greedy Algorithm
public class Main {
    public static void main(String[] args) {
        int [] values = {1, 5, 10, 25, 50};
        int amount = 693;
        int[] result = coinChange(values, amount);
        System.out.println("Coin Change Problem using Greedy Algorithm");
        System.out.println("Amount: " + amount);
        System.out.println("Coins: ");
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                System.out.println(result[i] + " x " + values[i]);
            }
        }


    }

    public static int[] coinChange(int[] coins, int amount) {
        int[] result = new int[coins.length];
        int i = coins.length - 1;
        while (amount > 0) {
            if (amount >= coins[i]) {
                result[i]++;
                amount -= coins[i];
            } else {
                i--;
            }
        }
        return result;
    }
}