//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> intSet = new HashSet<Integer>();
        int repeat = -1;
        for (int i = 0; i < n; i++) {
            if(!intSet.add(nums[i])){
                return nums[i];
            }
        }
        return repeat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
