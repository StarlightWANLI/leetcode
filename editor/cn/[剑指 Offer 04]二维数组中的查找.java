//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //如果二维数组不是自增的，则直接暴力遍历二维数组寻找目标值

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, columns = matrix[0].length;
        //从每一行的最大值开始比较，所以column从大到小开始遍历
        //注意：这里row和column不能都从最大值开始遍历，不然就不知道指标移动的方向了
        //比如从30开始遍历，如果目标值是15，那么下一个指标怎么移动？？？
        int row = 0, column = columns - 1;

        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            //相当于每一个值，都需要横向和纵向比较
            if(num == target){
                return  true;
            }else if(num > target){
                column--;
            }else{
                //column要从最右侧开始比较，每行最大的数都小于target，那么只能换下一行
                row++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
