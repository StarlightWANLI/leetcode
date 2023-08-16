//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<String>();

    char[] c;
    //字符串的全排序，里面没有重复元素，采用回溯
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    
    //回溯算法：深度优先，从首字母char[0]开始遍历
    void dfs(int x){
        if(x == c.length - 1){  //满足长度后，将字符串添加到结果集中
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])){//重复，枝剪
                continue;
            }
            set.add(c[i]);
            
            swap(i,x);//交换,将char[i]固定在x位上
            dfs(x + 1);
            swap(i,x);//恢复交换
        }
    }
    //交换
    void swap(int x,int y){
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
