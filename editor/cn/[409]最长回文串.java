import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        //思路：所有成对出现的字符都能参加回文串组合，而出现奇数次数的字符，组多只能选取一个
        //1、字符计数
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        //2、偶数的正常计数，奇数位的字符,取第一个全部计数，其他的只能取偶数个计数
        int ans = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
           if(entry.getValue() % 2 == 0){
               ans+=entry.getValue();
           }else{
               if(ans% 2 == 0){
                   ans+=entry.getValue();
               }else{
                   ans+=entry.getValue() -1;
               }
           }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
