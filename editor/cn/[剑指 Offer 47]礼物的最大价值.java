//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {
        //二维数组的最值问题，典型的动态规划求最值
        //每次向右或向下移动一格

        //m是高，n是长
        int m = grid.length, n = grid[0].length;
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0 && i == 0){//初始化起始单元格
                    dp[0][0] = grid[0][0];
                }else if(j == 0 && i > 0){ //初始化第1行
                    dp[i][0] = dp[i - 1][0] +  grid[i][0];
                }else if(i == 0 && j > 0){//初始化第1列
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
