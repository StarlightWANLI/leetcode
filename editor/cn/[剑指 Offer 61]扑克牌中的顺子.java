//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<Integer>();
        int max = 0;
        int min = 14;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);

            if(repeat.contains(nums[i])){
               return false;
            }
            repeat.add(nums[i]);
        }
        return max - min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
