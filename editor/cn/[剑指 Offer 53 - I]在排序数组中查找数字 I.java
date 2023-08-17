//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //查找有序数组中target出现的次数
    public int search(int[] nums, int target) {
        //方法1：暴力遍历
        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                count++;
            }
        }
        return count;*/

        //方法2：二分查找
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target+1);
        return (first == nums.length || nums[first] != target) ? 0 : last - first;
    }

    //由于数组是有序的，可以通过二分查找快速找到最接近或等于target的第一个位置
    private int binarySearch(int[] nums, int target){
        int left = 0,right = nums.length;
        while(left < right){
             //中位下标
             int mid = left +    (right - left) / 2;
             if (nums[mid] >= target){//中位数大于等于目标值，则说明目标值target的起始坐标一定要中点的前面，所以结尾坐标变为中点mid
                 right = mid;
             }else{//中位数小于等于目标值，说明目标值target的起始坐标一定在中点后面，所以变更起始坐标为中点坐标
                 left = mid + 1;
             }
        }
        return left;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
