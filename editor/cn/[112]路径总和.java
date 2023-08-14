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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //根节点到叶子节点的路径，采用深度遍历中的前序遍历
        if(root == null){
            return  false;
        }
        if(root.right == null && root.left == null){
            return targetSum == root.val;
        }

        return hasPathSum(root.right,targetSum-root.val) ||
                hasPathSum(root.left,targetSum-root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
