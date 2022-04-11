//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1554 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SortList {

    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode head = createList(new int[]{4, 2, 1, 3});
        ListNode head1 = createList(new int[]{4, 3});
        ListNode head2 = createList(new int[]{});
        print(head);
        print(solution.sortList(head));
        print(solution.sortList(head1));
        print(solution.sortList(head2));
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
        /**
         * 首先想到排序算法，直接插入排序，快速排序，冒泡排序，归并排序
         * 其中直接插入排序和冒泡排序的时间复杂度为O(n^2)
         * 归并排序的时间复杂度为O(logn)
         * <p>
         * 直接插入排序：
         * 这里要想清楚，curr指针不是主动移动的
         * 而是curr指向的节点被插入有序区后，curr被动移动的
         * 也就是说curr相对有序区边缘是静止的，此时有序区边缘便承担了prev指针的作用
         */
//        public ListNode sortList(ListNode head) {
//            ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
//            ListNode lastSorted = fakeHead;
//            ListNode toMove = head;
//            while (toMove != null) {
//                ListNode node = findInsert(fakeHead, lastSorted, toMove);
//                ListNode next = toMove.next;
//                lastSorted.next = next;
//                if (toMove.val >= lastSorted.val) {
//                    lastSorted = toMove;
//                }
//                toMove.next = node.next;
//                node.next = toMove;
//                toMove = next;
//            }
//            return fakeHead.next;
//        }
//
//        private ListNode findInsert(ListNode begin, ListNode end, ListNode node) {
//            ListNode prev = begin;
//            ListNode curr = begin;
//            while (prev != end) {
//                if (node.val >= prev.val && node.val < curr.val) {
//                    return prev;
//                }
//                prev = curr;
//                curr = curr.next;
//            }
//            return prev;
//        }

        /**
         * 这里是采用归并排序做的（官方题解）
         * 需要注意的是当递归到最底层的时候，会将所有相邻的节点都拆开，变成n个孤立节点
         * 以至于此时整个链表的结构信息只包含在调用栈中，然后自低向上主键归并
         */
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            ListNode sorted = merge(list1, list2);
            return sorted;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
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

    private static ListNode createList(int[] array) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        for (int num : array) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return fakeHead.next;
    }

    private static void print(ListNode node) {
        ListNode curr = node;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
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

    private static void print(byte i) {
        System.out.println(i);
    }

    private static void print(char i) {
        System.out.println(i);
    }

    private static void print(short i) {
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

    private static void print(char[] arrays) {
        for (char item : arrays) {
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

    private static void print(int[][] arrays) {
        for (int[] item : arrays) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println();
    }

    private static void print(String[][] arrays) {
        for (String[] item : arrays) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println();
    }

}