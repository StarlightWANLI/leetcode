//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        //由于原来是升序排序，最小值初始在最前面，不管旋转多少次，最小值右边的值都是比最小值大，最大值左边的值始终比右变的小.
        //最小值右边的值，始终保持升序排序,右边也始终保持升序
        //典型的二分查找

        int low = 0;
        int high = numbers.length - 1;

        while (low < high){
            int pivot = low + (high - low) / 2;
            if(numbers[pivot] < numbers[high]){
                high = pivot;
            }else if(numbers[pivot] > numbers[high]){
                low = pivot + 1;
            }else{
                high -= 1;
            }
        }
        return numbers[low];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
