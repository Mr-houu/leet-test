package leetcode.editor.cn;

//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 529 👎 0

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();

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
            if (null == head) {
                return head;
            }
            // 创建一个哑结点，next指向head
            ListNode dummy = new ListNode(0, head);
            // 指针指向当前哑结点
            ListNode cur = dummy;
            // 循环遍历节点
            while (cur.next != null && cur.next.next != null) {
                // 节点相等，删除节点
                if (cur.next.val == cur.next.next.val) {
                    // 存储节点值，便于删除
                    int x = cur.next.val;
                    // 删除下一个满足条件的节点
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                } else {
                    // 条件不满足，跳到下一个节点
                    cur = cur.next;
                }
            }
            // 返回头结点
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}