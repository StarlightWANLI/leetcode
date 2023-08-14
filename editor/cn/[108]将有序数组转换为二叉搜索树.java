//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //数组已经升序排列
        //高度平衡的二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
        //选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1，可以使得树保持平衡。如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点
        return helper(nums,0,nums.length-1);
    }

    //每次递归，选取中间数字作为根节点
    private TreeNode helper(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;

        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = helper(nums,left,mid - 1);
        rootNode.right = helper(nums,mid + 1,right);
        return rootNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
