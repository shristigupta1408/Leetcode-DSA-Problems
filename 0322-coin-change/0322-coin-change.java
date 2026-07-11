class Solution {
    public int coinChange(int[] coins, int amount) {
        // Fewest number of coins - start with the biggest number
        // Array - sorted or not sorted?
        // Recurrence relation - 1 + coinChange(coins, amount-coin)
        // Base Case - NP - return -1, 0 -> return 0
        // If currAmount + coin > amount -> continue;
        // Maintain currentAmount && number of coins

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}