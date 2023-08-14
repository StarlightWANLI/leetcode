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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //判定B是否是A的子树，只需要判定B是否是A中的节点
        return  (A !=null && B!=null) &&
        (recur(A,B) || isSubStructure(A.left,B) ||  isSubStructure(A.right,B));
    }

    //树节点相等判断
    public boolean recur(TreeNode A, TreeNode B) {
        if(B == null){return true;}
        if(A==null || A.val != B.val ){return false;}
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
