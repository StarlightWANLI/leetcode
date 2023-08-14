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
    public boolean isBalanced(TreeNode root) {
        //平衡树：左右树的高度差不超过1
        if(root == null){
            return true;
        }
        return Math.abs(heightTree(root.left) - heightTree(root.right)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private  int heightTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
