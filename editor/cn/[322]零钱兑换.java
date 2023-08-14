//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //计算和为amount的最少金币个数
        //dp[n]表示钱币 n 可以被换取的最少的硬币数，不能换取就为 −1
        //dp[i]有两种实现的方式，去两者的最小值
        //1、包含当前的coins[i]，那么剩余钱就是 i−coins[i]，这种操作要兑换的硬币数是 dp[i−coins[j]]+1
        //2、不包含，要兑换的硬币数是 dp[i]
        //递推公式为 dp[amount] = min (dp[amount - coin] + 1, dp[amount])

        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // dp[n]的值:表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount+1];
        // 给dp赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(dp,amount+1);

        dp[0] = 0;

        for(int i = 1; i <= amount;i++){//i表示总金额
            for(int j = 0;j < coins.length;j++){//j表示第几个金币
                if(i - coins[j] >= 0){
                    // dp[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 dp[i-coins[j]] + 1
                    // 另一种就是不包含，dp[i]
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
