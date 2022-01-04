//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2110 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode node1 = new ListNode(-9, new ListNode(3, null));
        ListNode node2 = new ListNode(5, new ListNode(7, null));
        ListNode result = solution.mergeTwoLists(node1, node2);

        ListNode node3 = new ListNode(-9, null);
        ListNode node4 = new ListNode(5, null);
        ListNode result1 = solution.mergeTwoLists(node3, node4);

        ListNode node5 = null;
        ListNode node6 = new ListNode(5, null);
        ListNode result2 = solution.mergeTwoLists(node5, node6);
        System.out.println();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode point1 = list1;
        ListNode point2 = list2;
        ListNode pointResult = result;
        while (point1 != null || point2 != null) {
            if (point1 == null) {
                pointResult.next = new ListNode(point2.val);
                point2 = point2.next;
                pointResult = pointResult.next;
                continue;
            }
            if (point2 == null) {
                pointResult.next = new ListNode(point1.val);
                point1 = point1.next;
                pointResult = pointResult.next;
                continue;
            }
            if (point1.val < point2.val) {
                pointResult.next = new ListNode(point1.val);
                point1 = point1.next;
            } else {
                pointResult.next = new ListNode(point2.val);
                point2 = point2.next;
            }
            pointResult = pointResult.next;
        }
        return result.next;
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
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(double[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(float[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(long[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(int[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(Object[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static <T> void print(Collection<T> collection) {
        for (T item : collection) {
            System.out.println(item);
        }
    }
}