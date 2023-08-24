//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //求第一个唯一字符
    // 由于要确认唯一，所以一定要遍历完全部字符
    // 由于要判断是否唯一，用Map记录次数记录所有字符,也可以用有序的LinkedHashMap
    public char firstUniqChar(String s) {
        if(s == null || "".equals(s) ){
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (Character c : s.toCharArray()) {
            if(map.containsKey(c)){
                //dic.put(c, !dic.containsKey(c));   也可以不计数，第一次存放值为false，后续如果重复存放改为true。这样取第一个为true的值就可以了
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        for (Character c : s.toCharArray()) {
            if(map.get(c) != null && map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
