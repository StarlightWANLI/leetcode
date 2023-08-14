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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //将每层的节点遍历完后，值放入ret的最前面
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = nodeQueue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = nodeQueue.poll();
                level.add(node.val);

                if(node.left!=null){
                    nodeQueue.offer(node.left);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                }
            }
            //放在集合头部
            ret.add(0,level);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
