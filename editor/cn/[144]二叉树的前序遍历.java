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
    //二叉树的前序遍历：按照访问根节点——》左子树——》右子树的方式遍历这棵树，
    //而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root,res);
        return res;
    }

    public void preorder(TreeNode root,List<Integer> res){
        if(root == null){
             return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
