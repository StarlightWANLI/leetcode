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
    public int[] levelOrder(TreeNode root) {
        //从上到下打印，也就是层序遍历
        if(root == null){
            return new int[0];
        }
        //结果
        List<Integer> results = new ArrayList<Integer>();

        //每层的节点,先进先出，采用队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            //弹出头部元素
            TreeNode node = queue.poll();
            results.add(node.val);

            if(node.left!=null){queue.offer(node.left);}
            if(node.right!=null){queue.offer(node.right);}
        }
        int[] res = new int[results.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = results.get(i);
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
