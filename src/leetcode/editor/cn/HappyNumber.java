//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 哈希表 数学 双指针 👍 768 👎 0

package leetcode.editor.cn;

import java.util.*;

public class HappyNumber{
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        print(solution.isHappy(19));
        print(solution.isHappy(2));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
     * 这道题主要在于发现规律，其中 getNext(99) = 162，也就是说作为2位数的最大值，99还是有继续提升为3位数的可能性的
     * 但是 getNext(999) = 243，999作为3位数的最大值，其结果仍是3位数且比本值小
     * 而 getNext(9999999999999) = 1053，getNext(9999) = 324
     * 也就是说输入1-9999999999999的一个数，最终都会回落到3位数以内，明确来说都会回落到243以内
     * 而243内的数是固定的，即便是最坏的情况当数据把243个数都经历了一遍，那第244个数也一定会到达之前经历过的某个数上，从而形成循环
     * 最终，只有2种可能
     * 一：n最终回落到1
     * 二：n最终落入某个循环
     *
     * 最终这道题和判断链表是否有环是同一解法
     */
    public int getNext(int n) {
        int total = 0;
        while (n != 0) {
            total += (n % 10) * (n % 10);
            n /= 10;
        }
        return total;
    }

    public boolean isHappy(int n) {
        return isHappy1(n);
    }

    /**
     * hash表法
     */
    public boolean isHappy0(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢指针法
     */
    public boolean isHappy1(int n) {
        int slow = getNext(n);
        int fast = getNext(getNext(n));
        while (slow != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


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