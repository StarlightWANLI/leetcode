//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        //采用动态规划

        int ans = 0;
        //1、用数组保存中间结果,dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
        int n = s.length();
        boolean [][] dp = new boolean[n][n];

        //2、遍历字符串
        for (int i = 1; i <= n; i++) {//长度为1
            for (int j = 0; j + i - 1 < n; j++) {
                int start = j;
                int end = j + i - 1;
                System.out.println(start + "-" + end);

                if(i == 1){
                    dp[start][end] = true;
                    ans++;
                }else if(i == 2){
                    if(s.charAt(start) == s.charAt(end)){
                        dp[start][end] = true;
                        ans++;
                    }
                }else{
                    if(s.charAt(start) == s.charAt(end)){
                        if(dp[start+1][end-1]){
                            dp[start][end] = true;
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
