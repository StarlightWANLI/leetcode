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
    public int sumOfLeftLeaves(TreeNode root) {
        //叶子节点：没有子节点的节点
        if(root == null){
            return 0;
        }
        return dfs(root);
    }

    public int dfs(TreeNode root){
        int res = 0;
        if(root.left!=null){
            if(isLeafNode(root.left)){
                res += root.left.val;
            }else{
                res += dfs(root.left); 
            }
        }
        if(root.right!=null && !isLeafNode(root.right)){
            res += dfs(root.right);
        }
        return  res;
    }

    public boolean isLeafNode(TreeNode node){
        return node.left==null && node.right==null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
