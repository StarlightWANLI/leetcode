//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //n个骰子扔出，各种 （点数之和s) 出现的概率
    //单个骰子扔出，1，2，3，4，5，6出现的概率都是1/6
    //状态转移方程：6个骰子之和的概率 = (5个骰子之和最小值的概率 + 1) * 单个骰子1的概率  + （5个骰子之和最小值 + 2) + 的概率 * 单个骰子2的概率 + ……
    //所以可以采用动态规划，这里的难点是，dp数组是从长度为6开始变化的
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);

        for(int i = 2;i <= n;i++) {
            // 1个骰子， 和有6个值
            // 2个骰子， 和有 2 * 6 - 1 = 11,因为最小值不可能为1
            //3个骰子， 和有 3 * 6 - 2 = 11,因为最小值为3
            //n个骰子， 和有 n * 6 - (n-1) = 11,因为最小值为n，把不可能出现的数减去
            double [] tmp = new double[ 5 * i + 1];

            //在上一个dp数组的基础上，多一个骰子，则需要计算之前骰子和的概率 + 1 ~ 5 的概率之和
            for(int j = 0;j < dp.length;j++) {

                for (int k = 0;k < 6;k++) {
                  tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
