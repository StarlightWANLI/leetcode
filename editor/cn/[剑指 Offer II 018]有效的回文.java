import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //1.定义集合存储有效字符
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                list.add(Character.toLowerCase(s.charAt(i)));
            }
        }

        //2.双指针判断是否回文
        int left = 0;
        int right = list.size() - 1;
        while (left < right){
            if(!list.get(left).equals(list.get(right))){
                  return false;
            }
            left++;
            right--;
        }
        return  true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
