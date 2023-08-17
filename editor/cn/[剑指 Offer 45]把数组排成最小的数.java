//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //把数组排成最小的数：本质上是排序问题
    //不过排序规则不是按大小排序，而是 如果  'x' + 'y'拼接的数字如果大于'y' + 'x'拼接的数字,则y需要排在前面
    public String minNumber(int[] nums) {
        //转为字符串数组
        String [] strs = new String[nums.length];
        for (int i = 0; i < strs.length;i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //对字符串进行快速排序
        quickSort(strs,0,strs.length-1);

        //采用StringBuilder进行字符串拼接
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();
    }

    //快速排序
    void quickSort(String[] strs, int start, int end){
        if(start >= end){
            return;
        }
        int i = start,j = end;
        //起始值：作为二分比较的依据
        String tmp = strs[start];
        while(i < j){
            //依次和基准字符串strs[start]组装成字符串比较
            while((strs[j] + strs[start]).compareTo(strs[start] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[start]).compareTo(strs[start] + strs[i]) <= 0 && i < j) i++;

            //交换i和j的值
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        //将位置i的值和基准值交换
        strs[i] = strs[start];
        strs[start] = tmp;
        quickSort(strs, start, i -1);
        quickSort(strs,i+1,end);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
