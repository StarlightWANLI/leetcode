//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
//
// Related Topics 字符串 动态规划 👍 594 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //由于数字0~25对应字母a~z，相邻数字以0~25的数字来拆分，有多少种拆分方式，就有多少种翻译方法
    //新增一个字符，那么可能有2种翻译：
    //1、单独作为一位来翻译
    //2、第i-1位和第i位组成的数字在10~25之间，可以把两位数连起来翻译
    //状态转移方程： f（i） = f(i-1) + f(i-2)  条件：i - 1>=0, 10<=x<=25 ,其中i等于字符串的第i个位置
    //动态规划:爬楼梯的升级版，满足条件才能爬两格。即两个数字凑起来大于等于10且小于26
    //和爬楼梯一样，由于只需要关注i-1 + i-2的值，所以不需要声明dp数组来保存所有的临时结果
    public int translateNum(int num) {
        String str = String.valueOf(num);

        //f(0) = 1，就一个数字，只有一种翻译

        //p表示i-2时的总翻译方法
        //q表示i-1时的总翻译方法
        //r表示i的总翻译方法,f(0) = 1，一个数字，只有一种翻译，所以r的初始值为1
        int p =0,q=0,r=1;
        for (int i = 0; i < str.length() ; i++) {
             p = q;
             q = r;

             //移动一位后，翻译数r需要重新计算
             r = 0;

             //如果只翻译当前数字，加上前1位的翻译之和q
             r += q;

             if (i == 0) {
                 continue;
             }
             //如果前2位组成的数字在10~25之间，则还需要加上p
             String pre = str.substring(i - 1,i + 1);
             if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                 //加上前2位的翻译之和p
                 r += p;
             }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
