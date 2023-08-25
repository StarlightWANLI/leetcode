//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //前驱节点 pre,头部节点head
    Node pre,head;

    //二叉搜索树转成递增的双向链表，二叉树采用中序遍历
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);

        //循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历：先左，root中，再右
    void dfs(Node cur){
        if(cur == null) return;

        dfs(cur.left);

        if(pre != null) pre.right = cur;
        else head = cur;//前驱节点为null的时候，设置当前节点为head节点

        //更新当前节点的前驱节点
        cur.left = pre;

        //更新前驱节点
        pre = cur;

        dfs(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
