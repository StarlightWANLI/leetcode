//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //最值问题，考虑动态规划,n个台阶的消耗，每次1或2个台阶 dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2])
        int n = cost.length;
        int [] dp = new int[n + 1];
        //由于可以选择下标 0 或 1 作为初始阶梯，因此有 dp[0]=dp[1]=0。
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
       return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
