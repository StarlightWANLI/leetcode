//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        final  int mod = 1000000007;
        if(n < 2){
            return n;
        }

        //动态规划，由于只用记录最近2次的求和结果，所以只用a，b两个变量存储最近的2次求和的结果
        int a = 0,b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
