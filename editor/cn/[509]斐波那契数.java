//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n < 2){
            return n;
        }

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
