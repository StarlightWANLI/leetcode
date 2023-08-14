//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //贪心算法：从左到右遍历数组每个位置，能种花的地方一定种上，这样就能保证种最多的花maxNum
        //种花的位置一定要更新对应坐标的值
        for (int i = 0; i < flowerbed.length; i++) {
            //分析每个位置能种花的情况
            if(
                    (i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0)   //如果是起始位置，需要保证右侧也为空
                    ||(i>0 && i< (flowerbed.length -1) && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0)//其他位置，左右两边都需要为空
                    ||(i == (flowerbed.length - 1) && (i-1)>=0  && flowerbed[i] == 0 && flowerbed[i-1] == 0)//终点位置，需要保证左侧为空
            ){
                n--;
                if(n<=0){
                    return  true;
                }
                //更新已经种花的位置
                flowerbed[i] = 1;
            }
        }
        return  n<=0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
