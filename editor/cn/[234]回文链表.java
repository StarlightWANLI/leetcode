//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        //1、将值保存到list集合中
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        //2、双指针判断是否回文
        int front = 0;
        int back = list.size() - 1;
        while (front < back){
            //出首尾不相等，则不是回文链表，返回false
            if(!list.get(front).equals(list.get(back))){
                  return false;
            }
            front++;
            back--;
        }
        return  true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
