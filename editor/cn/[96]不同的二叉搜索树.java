//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        //求所有的情况，这里考虑使用动态规划
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {//节点个数
            for (int j = 1; j <= i; j++) {//根元素位置
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
