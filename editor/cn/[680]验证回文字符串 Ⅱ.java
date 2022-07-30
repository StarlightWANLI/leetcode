import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        //双指针判断是否回文
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            //这里采用了贪心的思想，每一步都深入判断，求最优解。
            if(s.charAt(left) != s.charAt(right)){
                //出现左右不等的情况，需要判断left到right的子串 移除最前或最后的不相同字符后是否回文
                return validPalind(s,left+1,right) || validPalind(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    //判断left到right的字串是否回文
    public boolean validPalind(String s,int left,int right) {
        //双指针判断是否回文
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
               return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
