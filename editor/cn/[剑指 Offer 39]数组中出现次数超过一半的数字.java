//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //求数组中的众数，超过一般的数字
    //1、hash计数
    //2、排序取中
    //3、摩尔投票：只有超过1半的数，最终投票数才不为0
    public int majorityElement(int[] nums) {
       int x = 0,votes = 0;
       for (int  num  : nums){
           //投票数为0，才重新赋值
          if(votes == 0) x = num;
          //相等加1，不相等减1
          votes += (num == x ? 1 :-1);
       }
       return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
