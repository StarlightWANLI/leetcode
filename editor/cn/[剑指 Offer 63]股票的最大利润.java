//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //股票买卖的最大利润,
        //由于要先买后卖，所以买入价数组中的位置一定卖出价之前。由于有明显的前后顺序，且不关注中间结果，所以可以采用双指针法
        /*int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max =  Math.max(max,prices[j] - prices[i]);
            }
        }
        return max;*/
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            cost = Math.min(cost,price);
            profit = Math.max(profit,price - cost);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
