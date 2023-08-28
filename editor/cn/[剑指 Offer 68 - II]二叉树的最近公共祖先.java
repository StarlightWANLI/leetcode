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
    private TreeNode ans;

    public Solution(){
        this.ans = null;
    }

    //二叉树的深度遍历
    private boolean dfs(TreeNode root,TreeNode p ,TreeNode q){
         if(root == null) return false;
         //左节点是否是p、q其一的公共节点
         boolean lson = dfs(root.left,p,q);
         //右节点是否是p、q其一的公共节点
         boolean rson = dfs(root.right,p,q);

         //目标节点
         if( (lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
             ans = root;
         }
         //是否是公共节点
         return lson || rson || (root.val == p.val || root.val == q.val );
    }

    //二叉树的2个节点最近的公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         this.dfs(root, p, q);
         return this.ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
