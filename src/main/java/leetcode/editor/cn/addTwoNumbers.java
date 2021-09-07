//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学 👍 6676 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

class addTwoNumbers {
    //2021-08-31 16:38:25
    //两数相加
    //编号：[2]

    public static void main(String[] args) {
        Solution solution = new addTwoNumbers().new Solution();
        // TO TEST
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        solution.addTwoNumbers(l1, l2);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = null;
            ListNode l3Tmp = null;
            int n1 = 0;
            int n2 = 0;
            int residue = 0;

            do {
                n1 = l1 != null ? l1.val : 0;
                n2 = l2 != null ? l2.val : 0;
                int num = n1 + n2 + residue;
                residue = num / 10;
                num = num % 10;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
                if (l3 == null) {
                    l3 = l3Tmp = new ListNode(num);
                } else {
                    l3Tmp.next = new ListNode(num);
                    l3Tmp = l3Tmp.next;
                }
            } while (l1 != null || l2 != null);
            if (residue != 0) {
                l3Tmp.next = new ListNode(residue);
            }
            return l3;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}