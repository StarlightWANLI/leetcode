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
    public int kthLargest(TreeNode root, int k) {
        //二叉搜索树第k大的节点
        //二叉搜索树的中序遍历结果是递增的，所以先中序遍历，再取值
        if(root == null){
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return  res.get(k-1);
    }

    private  void postOrder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        postOrder(root.right,res);
        res.add(root.val);
        postOrder(root.left,res);
        
    }

}
//leetcode submit region end(Prohibit modification and deletion)
