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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        //用来保存上一层的节点
        List<TreeNode> queue = new LinkedList<>() {
            { add(root); }
        };
        //保存下一层的节点
        List<TreeNode> tmp;

        int res = 0;
        while(!queue.isEmpty()) {
            //用来存放新的一层的节点
            tmp = new LinkedList<>();

            //遍历上一层的每一个节点，把左右节点放入下一层的集合tmp中
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
