//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 611 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //求不包括重复元素的最长子字符串的长度
    //字符串子串的问题：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //采用双指针遍历，遇到重复的元素，左指针就跳到左边重复元素的后一位

        //使用map保存每个字符最新的位置
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int res = 0;
        //滑动窗口：起始下标，j每次都向右移动1位，i只有遇到重复元素且重复元素的位置大于i 才移动到重复元素的前1位
        int i = 0 ,j = 0;
        while (j < s.length()) {
            if(map.containsKey(s.charAt(j)) ) {
                //注意这里i值的变换条件：一定要满足遇到重复字符串， map.get(s.charAt(j)) + 1 > i ,避免i回头取到比当前i小的值
                i = Math.max(map.get(s.charAt(j)) + 1,i);
            }
            map.put(s.charAt(j),j);
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
