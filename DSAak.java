import java.util.Arrays;

public class DSAak {
    static int minCoins(int[] coins, int target) {
        int[] dp = new int[target + 1];
        int unreachable = target + 1;

        Arrays.fill(dp, unreachable);
        dp[0] = 0;

        for (int amount = 1; amount <= target; amount++) {
            for (int coin : coins) {
                if (coin <= amount && dp[amount - coin] != unreachable) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }

        return dp[target] == unreachable ? -1 : dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 4};
        System.out.println(minCoins(coins, 6));
    }
}