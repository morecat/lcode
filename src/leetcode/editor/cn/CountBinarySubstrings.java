//给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。 
//
// 重复出现（不同位置）的子串也要统计它们出现的次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "00110011"
//输出：6
//解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
//注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
//另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。 
//
// 示例 2： 
//
// 
//输入：s = "10101"
//输出：4
//解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '0' 或 '1' 
// 
// Related Topics 双指针 字符串 👍 444 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CountBinarySubstrings {

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new CountBinarySubstrings().new Solution();
        print(solution.countBinarySubstrings("00110011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            List<Integer> counter = new ArrayList<>();
            int count = 0;
            int ans = 0;
            char c = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                } else {
                    counter.add(count);
                    count = 0;
                    c = s.charAt(i);
                    i--;
                }
            }
            counter.add(count);
            for (int i = 1; i < counter.size(); i++) {
                ans += Math.min(counter.get(i), counter.get(i - 1));
            }
            return ans;
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