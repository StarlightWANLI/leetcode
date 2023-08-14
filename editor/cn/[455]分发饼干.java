import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //贪心算法，每一步都求最优解
        //发饼干，每次都正好满足孩子胃口的最小的饼干大小，注意这里每个孩子只能分配一块饼干
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for(int i=0,j = 0;i<g.length && j<s.length;i++,j++){
            while(j<s.length && g[i] > s[j]){//胃口大于饼干大小，则判断下一块饼干
                j++;
            }
            if(j < s.length){//饼干正好满足胃口，则加1
                count++;
            }
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
