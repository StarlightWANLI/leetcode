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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        //求最小值，初始值设置为Integer.MAX_VALUE
        int minRes = Integer.MAX_VALUE;
        if(root.left!=null){
            minRes = Math.min(minRes,minDepth(root.left));
        }
        if(root.right!=null){
            minRes = Math.min(minRes,minDepth(root.right));
        }
        return  minRes + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
