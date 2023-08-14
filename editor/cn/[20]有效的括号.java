//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isValid(String s) {
        int n = s.length();
        //如果为奇数，不能完成配对
        if (n % 2 == 1) {
            return false;
        }

        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};


        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                //如果ch是结束括号，且和栈中最近的一个元素匹配，则弹出栈中最近的一个元素
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            }else{
                //放入开始括号
                stack.push(ch);
            }
        }
        
        return  stack.isEmpty();
        

    }
}
//leetcode submit region end(Prohibit modification and deletion)
