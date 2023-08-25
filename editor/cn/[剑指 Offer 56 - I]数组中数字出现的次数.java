//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //找出数组中只出现一次的数字
    //异或运算有个重要的性质，两个相同数字异或为 0
    public int[] singleNumbers(int[] nums) {
        int x = 0,y = 0,n = 0, m = 1;
        for (int num : nums){// 1. 遍历异或,n中包含2个单一数字
            n ^= num;
        }

        while ((n & m) == 0){// 2. 循环左移，拆分出m
            m <<= 1;
        }

        for(int num : nums){// 3. 遍历 nums 分组
            if( (num & m ) != 0 ) x^=num; //若 num & m != 0 , 划分至子数组 1 ，执行遍历异或
            else y ^= num;//若 num & m == 0 , 划分至子数组 2 ，执行遍历异或
        }
        return new int[]{x,y};//4. 返回出现一次的数字
    }
}
//leetcode submit region end(Prohibit modification and deletion)
