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
        //第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null){
            return  res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        //用来控制每遍历一层，就切换遍历顺序
        boolean orderFlag = true;
        while (!queue.isEmpty()){
            //采用双端队列，控制数据存放的顺序
            Deque<Integer> levelList = new LinkedList<Integer>();
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if(orderFlag){
                    //正序
                    levelList.offerLast(node.val);
                }else{
                    //逆序
                    levelList.offerFirst(node.val);
                }

                //节点存放的顺序保持不变
                if(node.left!=null){queue.offer(node.left);}
                if(node.right!=null){queue.offer(node.right);}
            }
            res.add(new LinkedList<Integer>(levelList));
            orderFlag = !orderFlag;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
