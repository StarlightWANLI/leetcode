//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m,n,k;
    boolean [][] visited;

    public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0,0,0,0);
     }

        //深度优先：回溯,从小到到，直到边界 si表示水平坐标i的数位和，sj表示垂直坐标j的数位和
        //这里利用的更多是递归
        public int dfs(int i, int j, int si, int sj){
            //超出边界，超过数位和，已访问
            if(i >= m || j >= n || k < si + sj || visited[i][j]) return  0;
            visited[i][j] = true;

            //本身的格子 1 + 向右移动  + 向下移动
            return 1 + dfs(i + 1,j,(i + 1) % 10 != 0 ? si + 1 : si -8,sj)
             + dfs(i,j+1,si,(j + 1)%10!=0 ? sj + 1 : sj -8);
        }
}
//leetcode submit region end(Prohibit modification and deletion)
