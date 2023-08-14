//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<String>();

    char[] c;
    //字符串的全排序，采用回溯
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String(res.size()));
    }
    
    //回溯算法：深度优先
    public void dfs(int x){
        if(x = c.length - 1){  //长度满足，添加到结果集中
            res.add(String.valueOf(c));
            return;
        }
        
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])){//重复，枝剪
                continue;
            }
            set.add(c[i]);
            
            swap(i,x);//交换
            dfs(x + 1);
            swap(i,x);//恢复交换
        }
    }
    //交换
    void swap(int x,int y){
        char tmp = c[x];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
