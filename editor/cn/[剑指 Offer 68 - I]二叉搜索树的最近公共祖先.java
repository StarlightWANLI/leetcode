//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //二叉搜索树中2个节点最近的公共祖先
    //二叉搜索树特性：左 < 中 < 右  ,直接递归遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root.val < p.val && root.val < q.val) {
             return lowestCommonAncestor(root.right, p, q);
         }
         if(root.val > p.val && root.val > q.val){
             return lowestCommonAncestor(root.left, p, q);
         }
         return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
