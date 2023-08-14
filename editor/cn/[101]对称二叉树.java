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
    //二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        return  check(root,root);
    }

    public boolean check(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }else if(leftNode == null || rightNode == null){
            return false;
        }
        return (leftNode.val == rightNode.val) &&
                check(leftNode.left,rightNode.right) &&
                check(leftNode.right,rightNode.left)
                ;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
