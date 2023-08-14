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
    public boolean isBalanced(TreeNode root) {
        //平衡二叉树的定义：二叉树的每个节点的左右子树的高度差的绝对值不超过 1
        //递归检查每个节点左右节点的高度差
        if(root == null){
            return true;
        }
        return  Math.abs(height(root.left)-height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right)
                ;
    }

    //计算树的最大高度
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.right),height(node.left)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
