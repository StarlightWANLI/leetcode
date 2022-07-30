import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        //判断是否可以组成回文字串，只需要判断单词中字符是否成对出现。
        //即出现奇数个数的字符最多只能有1个
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            //如果新增没有成功，说明已经存在相同的字符，满足可以成对出现，删除
            if(!set.add(s.charAt(i))){
                set.remove(s.charAt(i));
            }
        }
        return  set.size()<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
