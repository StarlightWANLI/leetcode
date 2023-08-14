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
    public TreeNode increasingBST(TreeNode root) {
        //中序遍历，递增顺序搜索树
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);

        //设置一个虚拟的根节点
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for(Integer integer : res){
            currNode.right = new TreeNode(integer);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode root,List<Integer> res) {
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
