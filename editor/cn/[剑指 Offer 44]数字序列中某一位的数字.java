//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
//
// Related Topics 数学 二分查找 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        //递推公式：
        //digtit = digtit + 1
        //start =  start * 10
        //count = 9 * start * digit
         //数位
         int digit = 1;
         //数位起始数字
         long start = 1;
         //数位总个数
         long count = 9;
        //1、确定 n 所在 数字 的 位数 ，记为 digit ；
         while (n > count) {
             n -= count;
             digit += 1;
             start *= 10;
             count = digit * start * 9;
         }
        //2、确定 n 所在的 数字 ，记为 num ；
        long num = start + (n - 1)/digit;

        //3、确定 n 是 num 中的哪一数位，并返回结果。 最后的 -'0' 是为了字符转数字
        return  Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
