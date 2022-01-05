//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2184 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
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

    /**
     * 存在迭代和递归2种解法
     */
    public ListNode reverseList(ListNode head) {
        return reverseList2(head);
    }

    /**
     * 递归方式
     */
    public ListNode reverseList1(ListNode head) {
        // 1. head.next == null 为递归终止条件，head == null是为了兼容初始输入为null的情况
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 完成后面数据的递归反转
        ListNode tail = reverseList1(head.next);
        // 3. 重建当前节点和下个节点的连接
        head.next.next = head;
        // 4. 此时会出现一个双元素组成的环，如果没有下面的 head.next = null;的话，
        // 链表原来的头节点会和第二个节点之间产生小环，那样就需要代码额外处理，写起来比较麻烦，不如在处理每个元素的时候都保证没有环结构
        head.next = null;
        return tail;
    }

    /**
     * 递归方式
     * 需要3个指针 prev curr next, 其中 prev 和 curr 负责重建链表节点指向，next用于暂存下个节点，以便重建节点指向后能够成功找到原来的下个节点
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            // 1.先暂存原来的下个节点
            next = curr.next;
            // 2.重建节点间指向
            curr.next = prev;
            // 3.向后遍历
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

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

    private static void print(boolean b) {
        System.out.println(b);
    }

    private static void print(double d) {
        System.out.println(d);
    }

    private static void print(float f) {
        System.out.println(f);
    }

    private static void print(long l) {
        System.out.println(l);
    }

    private static void print(int i) {
        System.out.println(i);
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static void print(boolean[] arrays) {
        for (boolean item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(double[] arrays) {
        for (double item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(float[] arrays) {
        for (float item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(long[] arrays) {
        for (long item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(int[] arrays) {
        for (int item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(Object[] arrays) {
        for (Object item : arrays) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static <T> void print(Collection<T> collection) {
        for (T item : collection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}