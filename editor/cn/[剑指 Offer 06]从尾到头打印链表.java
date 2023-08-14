//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        //由于要倒序输出，这里采用栈，先进后出的特性
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            //pop弹出元素
            print[i] = stack.pop().val;
        }
        return print;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
