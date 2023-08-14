//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        int n = nums.length;
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            output.add(nums[i]);
        }

        backtrack(n,output,res,0);
        return  res;
    }


    /**
     * Javadoc Method Summary.
     * @param n      数组长度
     * @param output 数组
     * @param res    排序后的列表集合
     * @param first  从第几个开始置换
     * @return
     */
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = first; i < n; i++) {
            // 将第i个元素和头部元素交换位置，然后基于新集合去递归遍历
            Collections.swap(output, first, i);

            // 继续递归填下一个数，每一个元素，都要依次和他后面的元素交换位置
            backtrack(n, output, res, first + 1);

            //复原集合位置
            Collections.swap(output, first, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
