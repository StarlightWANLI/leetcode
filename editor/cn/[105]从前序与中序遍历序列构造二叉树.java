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
    private Map<Integer,Integer> indexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据前序遍历和中序遍历还原二叉树
        //前序遍历先访问root节点，中序遍历满足root节点前面的元素都是左节点，右边的元素都是右节点
        int n = inorder.length;
        indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return mybuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    
    
    public  TreeNode mybuildTree(int[] preorder, int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left > preorder_right){
            return null;
        }

        // 前序遍历中的第一个节点就是根节点 
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点 
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        //递归构造左节点
        //前序遍历中左子树节点的范围为[preorder_left+1,preorder_left + size_left_subtree]
        //中序遍历中，左子树的范围为：[inorder_left,inorder_root-1]
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = mybuildTree(preorder,inorder,preorder_left+1,preorder_left + size_left_subtree,
                inorder_left,inorder_root-1);

        //递归构造右节点
        //前序遍历中，右子树节点的范围为[preorder_left + size_left_subtree + 1,preorder_right]
        //中序遍历中，右子树节点的范围为：[inorder_root+1,inorder_right]
        root.right = mybuildTree(preorder,inorder,preorder_left + size_left_subtree + 1,preorder_right,
                inorder_root + 1,inorder_right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
