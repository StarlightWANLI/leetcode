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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }


    /**
     * 构造二叉树节点
     * @param preorder  前序遍历：节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
     * @param inorder   中序遍历：节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
     * @param preStart
     * @param preEnd
     * @param inoStart
     * @param inoEnd
     * @return
     */
    TreeNode build(int[] preorder, int[] inorder,int preStart,int preEnd,int inoStart,int inoEnd){
        //base case
        if(preStart > preEnd || inoStart > inoEnd){
            return null;
        }
        //树的根节点
        int val = preorder[preStart];
        TreeNode root =  new TreeNode(val);
        //查找根节点在中序遍历的位置
        int index = 0;
        for(int i = inoStart;i <= inoEnd;i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        //计算左子树在数组中的长度
        int leftSize = index - inoStart;
        //递归构建
        root.left = build(preorder,inorder,preStart + 1,preStart + leftSize,inoStart , index - 1);
        root.right = build(preorder,inorder,preStart + leftSize + 1,preEnd,index + 1 , inoEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
