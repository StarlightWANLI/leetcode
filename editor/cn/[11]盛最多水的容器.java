//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //初始化双指针的位置
        int left = 0;
        int right = height.length -1;

        int max = 0;

        while (left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max,area);

            //移动边界值较小的指针
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return  max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
