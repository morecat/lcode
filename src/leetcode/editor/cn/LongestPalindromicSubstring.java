//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4994 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.regex.*;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        print(solution.longestPalindrome("babad"));
        print(solution.longestPalindrome("cbbd"));
        print(solution.longestPalindrome("bb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 以开始坐标，结束坐标为维度构建动态规划空间
         * 为什么不能分别以begin,end作为内外循环的指针
         * 因为计算dp的时候依赖dp[i+1][j-1]，采用begin,end无法保证dp[i+1][j-1]已被计算过
         */
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int maxLen = 1;
            int begin = 0;
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int l = 2; l <= s.length(); l++) {
                for (int i = 0; i < s.length(); i++) {
                    int end = i + l - 1;
                    if (end >= s.length()) {
                        continue;
                    }
                    if (s.charAt(i) != s.charAt(end)) {
                        dp[i][end] = false;
                    } else {
                        if (l < 3) {
                            dp[i][end] = true;
                        } else {
                            dp[i][end] = dp[i + 1][end - 1];
                        }
                    }
                    if (dp[i][end] && l > maxLen) {
                        maxLen = l;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
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