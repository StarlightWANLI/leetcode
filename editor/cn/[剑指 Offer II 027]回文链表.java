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
        List<Integer>  list = new ArrayList<>();

        //1.将链表的值复制到list集合中
        ListNode currentNode = head;
        while(currentNode != null){
            list.add(currentNode.val);
            currentNode = head.next;
        }

        //2.用双指针判断判断是否回文
        int left = 0;
        int right = list.size()-1;
        while (left < right){
            if(list.get(left).equals(list.get(right))){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
