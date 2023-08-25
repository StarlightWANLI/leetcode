//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //找出递增数组中缺失的数字，所有数字都是唯一,数字范围：0～n-1内的n个数字
    public int missingNumber(int[] nums) {
          Set<Integer> set = new HashSet<Integer>();
         for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
         }

          int missing = -1;
          //0对应     nums[0]
          //n-1对应   nums[nums.length -1]
         //由于数字缺1，所以遍历 0到nums.length的数字，判断缺少那一个数字
          for (int i = 0; i <= nums.length; i++){
                if(!set.contains(i)){
                    missing = i;
                    break;
                }
          }
          return  missing;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
