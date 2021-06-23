package leetcode.editor.cn;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 495 👎 0

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
/*            if (null == head) {
                return head;
            }
            // 创建一个哑结点
            ListNode dummy = new ListNode(0, head);
            // 当前指针指向哑结点
            ListNode cur = dummy;
            // 循环遍历节点
            while (cur.next != null && cur.next.next != null) {
                // 条件满足，保留一个节点，删除其他值相同的节点
                if (cur.next.val == cur.next.next.val) {
                    cur.next = cur.next.next;
                } else {
                    // 条件不满足，跳到下一个节点
                    cur = cur.next;
                }
            }
            return dummy.next;*/


            if (null == head) {
                return head;
            }
            // 当前指针指向头结点
            ListNode cur = head;
            // 循环遍历节点
            while (cur != null && cur.next != null) {
                // 条件满足，删除next的节点
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    // 条件不满足，跳到下一个节点
                    cur = cur.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}