//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    //链表的第一个公共节点：注意由于是单向链表，所以2节点相等，表示2节点指向同一引用指针，后续节点也都相等
    //方式1：哈希表
    //方式2：双指针
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针：比较难理解
        /*if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            //会不会出现无限循环，不能跳出的问题
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }
        return pA;*/
        
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
             set.add(temp);
             temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if(set.contains(temp)){
                return temp ;
            }
            temp = temp.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
