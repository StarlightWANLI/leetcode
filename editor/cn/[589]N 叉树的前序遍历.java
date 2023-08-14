//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    //N叉树的前序遍历，和二叉树的类似，也是递归遍历
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public void helper(Node root,List<Integer> res){
        if(root == null){
            return;
        }
        //前序遍历，先访问中间节点
        res.add(root.val);
        for(Node node : root.children){
            helper(node,res);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
