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
    public boolean isValidBST(TreeNode root) {
        //二叉搜索树定义如下：
        //节点的左子树只包含 小于 当前节点的数。
        //节点的右子树只包含 大于 当前节点的数。
        //所有左子树和右子树自身必须也是二叉搜索树。
         return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node,long lower,long upper){
        if(node == null){
            return true;
        }
        if(node.val <= lower || node.val >= upper){
            return false;
        }
        //移到下一个左节点判定，上限改变
        //移到下一个右节点判定，下限改变
        return isValidBST(node.left,lower,node.val) &&
        isValidBST(node.right,node.val, upper);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
