//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 469 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ValidPalindromeIi {

    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        print(solution.validPalindrome("aba"));
        print(solution.validPalindrome("abca"));
        print(solution.validPalindrome("abc"));
        print(solution.validPalindrome("ebcbbececabbacecbbcbe"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 判断回文串的方法主要就是靠双指针
         * 因此可以先使用双指针遍历着，如果遇到不满足回文条件的，则尝试删除左边的字符或者右边的字符，对删除字符后的2个子串分别进行回文判断
         *
         */
        public boolean validPalindrome(String s) {
            int begin = 0;
            int end = s.length() - 1;
            while (begin < end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    return validPalindrome(s, begin, end - 1)
                            || validPalindrome(s, begin + 1, end);
                }
                begin++;
                end--;
            }
            return true;
        }

        public boolean validPalindrome(String s, int begin, int end) {
            while (begin < end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
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