//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //求第n个丑数
    //丑数：取2、3 和 5中的任意1个或多个相乘得到的数,
    //使用一个优先队列保存所有的丑数，每次取出最小的那个，然后乘以 2 , 3 , 5 后放回队列
    public int nthUglyNumber(int n) {
          //由于丑数由2,3,5三数组成，这里采用3指针,记录每个数字用到的次数，总体来说，要尽可能多用小的数字，这样求的结果会最小
          int a = 0, b = 0, c = 0;

          int [] res = new int[n];
          //初始化为1，也是丑数
          res[0] = 1;

          //从小到大求丑数，并保存到数组中
          for (int i = 1; i < n; i++){
              //由于一般  a>= b >= c, 所以新一轮计数中最小值在res[a] * 2、 n3 = res[b] * 3、n5 = res[c] * 5 中
              int n2 = res[a] * 2, n3 = res[b] * 3,n5 = res[c] * 5;

              //取3数的中的最小值
              res[i] = Math.min(Math.min(n2,n3),n5);

              //根据哪一个是最小值，判断使用的是2，3，5中的哪个数字相乘的，并对计数+1
              if(res[i] == n2) a++;
              if(res[i] == n3) b++;
              if(res[i] == n5) c++;
          }
          return  res[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
