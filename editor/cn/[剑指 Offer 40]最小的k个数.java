//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //TopN问题:获取最小的k个数
    //这里获取最小的k个元素，并不需要k个元素是完全有序的,所以可以采用快速排序逐步拆分。 当需要拆分的下标j等于k时，即可以直接获取
    //快排的基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        //最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr,0,arr.length-1,k-1);
    }

    private int[] quickSearch(int[] nums,int lo,int hi,int k){
        //每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int j = partition(nums,lo,hi);
        System.out.println("切分位置：" + j);
        if(j == k){
            return Arrays.copyOf(nums,j+1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums,lo,j-1,k) : quickSearch(nums,j+1,hi,k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    // 比如，2,5,3,1,7  0~4， 返回1,2,5,3,7,返回1
    private int partition(int[] nums,int lo,int hi){
        int v = nums[lo];
        int i = lo,j=hi + 1;
        while (true){
             while(++i <= hi && nums[i] < v);
             while(--j >= lo && nums[j] > v);
             if(i >= j){
                 break;
             }
             int t = nums[j];
             nums[j] = nums[i];
             nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
