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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return  generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        
        for(int i=start;i<=end;i++){
            //二叉搜索树定义如下：
            //节点的左子树只包含 小于 当前节点的数。
            //节点的右子树只包含 大于 当前节点的数。
            //所有左子树和右子树自身必须也是二叉搜索树。

            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start,i-1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
