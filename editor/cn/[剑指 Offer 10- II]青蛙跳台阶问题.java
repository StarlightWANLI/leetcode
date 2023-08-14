//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        //动态规划：
        // 1、倒数第1个台阶只需要再跳1个台阶
        // 2、倒数第2个台阶，只需要再跳2个台阶
        // 跳到倒数第1个台阶的跳法   和  跳到倒数第2个台阶的跳法  一定不会重复
        //推导出：f(n)=f(n-1)+f(n-2)
        if(n<2){
            return 1;
        }
        int a=0,b=1,sum =1;
        for (int i = 0; i < n; i++) {
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
