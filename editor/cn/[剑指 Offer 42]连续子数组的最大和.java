//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //状态转移方程：这里的动态规划其实只用关注前面的一个值即可
        //dp[i]表示以nums[i]结尾的连续子数组的最大和，所以nums[i]的原始值必须参与计算
        //1、如果 dp[i-1] > 0 ,则 dp[i] = dp[i-1] + nums[i]
        //2、如果 dp[i-1] < 0 ,则说明前面都是负贡献，不如只计算自己， dp[i] = nums[i]
        //遍历数组，只累计大于0的值
        int max = nums[0];
        //方案二：这里直接采用原数组nums[i]记录前面i个元素的最大值，只累计大于0的值
        /*for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i-1],0);
            max = Math.max(max,nums[i]);
        }*/

        //方案三：为了不改变数组的原始值，声明pre表示包括当前元素的连续子集合计的最大值，主要是为了保证数组连续
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre  = nums[i] + Math.max(pre,0);
            max = Math.max(max,pre);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
