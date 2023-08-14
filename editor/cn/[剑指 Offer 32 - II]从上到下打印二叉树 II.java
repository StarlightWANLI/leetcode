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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //从上到下逐层打印，采用层序遍历
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return  res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            //这里一定要先获取队列的长度，再执行for循环遍历，因为循环的过程中queue会改变，i < queue.size()
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){queue.offer(node.left);}
                if(node.right!=null){queue.offer(node.right);}
            }
            res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
