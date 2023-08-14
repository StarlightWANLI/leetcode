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
    //多叉树的后序遍历，和二叉树类似，采用递归遍历
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public  void helper(Node root,List<Integer> res){
        if(root == null){
            return;
        }
        //后序遍历，最后访问中间节点
        for(Node node : root.children){
            helper(node,res);
        }
        res.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
