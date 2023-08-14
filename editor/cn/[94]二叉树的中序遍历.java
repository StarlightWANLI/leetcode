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
    //前中后遍历中的前中后指的是根节点root所处的位置
    //二叉树的中序遍历：按照访问左子树——》根节点——》右子树的方式遍历这棵树，左子树开始顺时针
    // 而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    
    //递归遍历二叉树
    public void inorder(TreeNode root,List<Integer> res){
        if(root ==  null){
            return;
        }
        //遍历左树
        inorder(root.left,res);
        //放入root节点的值
        res.add(root.val);
        //遍历右树
        inorder(root.right,res);
    }
    
    
}
//leetcode submit region end(Prohibit modification and deletion)
