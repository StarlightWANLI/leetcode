//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //每个坐标下能够接的雨水 = Min(左侧最高，右侧最高) - 柱子本身高度
        //其中，计算每个柱子，左侧和右侧的最大值，可以采用动态规划，避免重复计算
        int n = height.length;
        if(n == 0){
            return 0;
        }
        //每个坐标左侧的最高柱子
        int[] leftMax = new int[n];
        //最左侧初始值
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            //只最需要和前一个左侧最大值比较
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        //每个坐标右侧的最高柱子
        int[] rightMax = new int[n];
        //最右侧初始值
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            //只最需要和紧临的右侧最大值比较
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans+= Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return  ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
