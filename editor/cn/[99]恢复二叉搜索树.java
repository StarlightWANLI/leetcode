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
    public void recoverTree(TreeNode root) {
        //核心：二叉搜索树的中序遍历是递增的
        //先通过二叉搜索树的中序遍历找到不满足条件的节点
        //然后交换二个节点的位置
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root,nums);

        int[] swapped = findTwoSwapped(nums);

        recover(root, 2, swapped[0], swapped[1]);
    }
    
    public  void inorder(TreeNode node,List<Integer> nums){
        if(node == null){
            return;
        }
        inorder(node.left,nums);
        nums.add(node.val);
        inorder(node.right,nums);
    }

    //找到相邻的非递增的2个数
    public int[] findTwoSwapped(List<Integer> nums){
        int n = nums.size();
        
        //相邻指针
        int index1=-1;
        int index2=-1;
        
        for (int i = 0; i < n-1; i++) {
            if(nums.get(i+1) < nums.get(i)){
                index2 = i+1;
                
                if(index1 == -1){
                    index1 = i;
                }else{
                    break;
                }
            }
        }
        int x = nums.get(index1);
        int y = nums.get(index2);
        return  new int[]{x,y};
    }

    /**
     * 递归遍历树，交换节点的值即可
     * @param root
     * @param count
     * @param x
     * @param y
     */
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) { return; }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
