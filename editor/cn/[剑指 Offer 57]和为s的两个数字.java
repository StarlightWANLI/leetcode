//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //在一个递增排序的数组中找到2个和为数字s的数
    ////由于是自增的，所有不用双重遍历，可以采用双指针从前后两个方向来计算
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            if(nums[left] + nums[right] > target) {
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] == target){
                break;
            }
        }
        return new int[]{nums[left], nums[right]};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
