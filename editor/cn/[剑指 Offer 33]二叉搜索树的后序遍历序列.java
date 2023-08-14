//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        //根据 后序遍历 的数组判断是否来源二叉搜索树
        //后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
        //二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。
        // 根节点为数组最后一个元素
        //思路：
        // 1、p = j ，即左节点数 + 右节点数 =  数组长度 - 1    判断 此树 是否正确
        // 2、recur(i, m - 1)  判断 此树的左子树 是否正确
        // 3、recur(m, j - 1)  判断 此树的右子树 是否正确
        return  recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[]  postorder,int i,int j){
        if(i >= j){
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]){
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j]){
            p++;
        }
        return p == j & recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
