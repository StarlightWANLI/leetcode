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
    public List<String> binaryTreePaths(TreeNode root) {
        //根节点到子节点的路径，所以需要采用深度优先遍历中的前序遍历
        List<String> paths = new ArrayList<String>();
        constructPaths(root,"",paths);
        return paths;
    }

    private void constructPaths(TreeNode root,String path,List<String> paths){
        if(root != null){
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            //判定叶子节点
            if(root.right==null && root.left==null){
                paths.add(pathSB.toString());
            }else{
                //非叶子节点，以左右节点作为root节点递归组装pathSB
                pathSB.append("->");
                constructPaths(root.right,pathSB.toString(),paths);
                constructPaths(root.left,pathSB.toString(),paths);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
