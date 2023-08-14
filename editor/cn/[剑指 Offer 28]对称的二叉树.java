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
    public boolean isSymmetric(TreeNode root) {
        //树的对称问题：采用双指针判定
        return check(root,root);
    }

    private boolean check(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return  false;
        }

        return  left.val == right.val &&
                check(left.left,right.right) &&
                check(left.right,right.left)
                ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
