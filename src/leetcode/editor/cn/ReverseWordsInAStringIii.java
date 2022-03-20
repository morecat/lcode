//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 包含可打印的 ASCII 字符。 
// s 不包含任何开头或结尾空格。 
// s 里 至少 有一个词。 
// s 中的所有单词都用一个空格隔开。 
// 
// Related Topics 双指针 字符串 👍 416 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ReverseWordsInAStringIii {

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        print(solution.reverseWords("Let's take LeetCode contest"));
        print(solution.reverseWords("God Ding"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 扫描过程中
         * 当指向的是第一个空格时，此时应该执行反转，此时bp指针一定位于单词的首字母处
         * 但是为了避免扫描到第二个连续空格时，还执行上述逻辑，因此在上述逻辑的末尾应该移动bp指针的位置，即bp = i
         */
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int bp = 0;
            int ep = bp;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ' && chars[bp] != ' ') {
                    ep = i - 1;
                    reverseWord(chars, bp, ep);
                    bp = i;
                } else if (chars[i] != ' ' && chars[bp] == ' ') {
                    bp = i;
                }
            }
            reverseWord(chars, bp, chars.length - 1);
            return new String(chars);
        }

        private void reverseWord(char[] chars, int begin, int end) {
            int bp = begin;
            int ep = end;
            char tmp;
            while (bp < ep) {
                tmp = chars[bp];
                chars[bp] = chars[ep];
                chars[ep] = tmp;
                bp++;
                ep--;
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

}