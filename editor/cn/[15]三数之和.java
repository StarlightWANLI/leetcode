//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4752 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
              int n = nums.length;
              //由于要防止重复，需要保证 a 《= b 《= c
              Arrays.sort(nums);

              List<List<Integer>> ans = new ArrayList<>();

              //第1个数first
              for (int first = 0; first < n; first++) {
                  //去重
                  if(first >0  && nums[first] == nums[first-1]){
                      continue;
                  }

                  int target = -nums[first];
                  //下面是采用双指针求second和third的值
                  //第3个数third
                  int third = n -1;
                  //第2个数 second
                  for (int second = first + 1; second < n; second++) {
                      // 需要和上一次枚举的数不相同
                      if (second > first + 1 && nums[second] == nums[second - 1]) {
                          continue;
                      }
                      // 需要保证 second 的指针在 third 的指针的左侧
                      while (second < third && nums[second] + nums[third] > target) {
                          --third;
                      }
                      if (second == third) { break; }

                      if (nums[second] + nums[third] == target) {
                          List<Integer> list = new ArrayList<Integer>();
                          list.add(nums[first]);
                          list.add(nums[second]);
                          list.add(nums[third]);
                          ans.add(list);
                      }
                  }
              }
              return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
