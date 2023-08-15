//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //求最长回文子串，最值问题，典型的动态规划:从长度较短的字符串开始计算

        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        //动态规划容器:记录字符串s[i..j]是否是回文串
        boolean [] [] dp = new boolean[len][len];

        //初始化：所有长度为1的子串都是回文串
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        //枚举所有子串
        for(int l = 2;l <= len;l++){
            for (int i = 0; i < len; i++) {
                //右边界
                int j = l + i - 1;
                if(j >= len){
                    break;
                }

                //相比公共子串，多了首尾比较
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    //比如：aba 这种长度小于3的子串，首尾相同就能确定是回文子串
                    if(j - i < 3){
                        dp[i][j] = true;
                    } else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //dp[i][j] 是回文子串，则更新maxLen
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
