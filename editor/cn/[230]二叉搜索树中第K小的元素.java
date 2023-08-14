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
    public int kthSmallest(TreeNode root, int k) {
        //二叉搜索树的中序遍历是顺序递增的
        //通过中序遍历找到二叉搜索树中第K个元素
        List<Integer> res = new ArrayList<Integer>();
        this.inorder(root,res);
        return res.get(k-1);
    }

    //中序遍历，先遍历左节点，再遍历root节点，然后遍历右节点
    public  void inorder(TreeNode node,List<Integer> res){
          if(node == null){
              return;
          }
          inorder(node.left,res);
          res.add(node.val);
          inorder(node.right,res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
