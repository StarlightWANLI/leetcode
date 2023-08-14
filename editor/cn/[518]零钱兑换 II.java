//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        //求组合数，每一种面额的硬币有无限个
        int[] dp = new int[amount + 1];
        //只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合。
        dp[0] = 1;

        for (int coin : coins) {
            //遍历 i 从 coin 到 amount，将 dp[i−coin] 的值加到 dp[i]。
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
