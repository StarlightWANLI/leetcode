import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return  new int[]{i,map.get(target - nums[i])};
            }else{
                dddd
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
