//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1183 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        print(solution.strStr("hello","ll"));
        print(solution.strStr("hello",""));
        print(solution.strStr("","l"));
        print(solution.strStr("mississippi","issip"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 本句用于回滚，之前错误的版本写作 i++，但i++表示无论如何针对haystack只会向前遍历，
                // 这导致"mississippi"中第一次遇到的"missis"使得i过度推进，进而导致与"missis"相交的"issip"被错过
                i = i -j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
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