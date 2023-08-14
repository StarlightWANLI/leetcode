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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
             return null;
        }
        //交换root节点的左右节点
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        //递归，交换左右子节点的位置
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
