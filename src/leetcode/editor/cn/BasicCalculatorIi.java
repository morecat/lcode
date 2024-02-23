//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics 栈 数学 字符串 👍 754 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BasicCalculatorIi {

    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        print(solution.calculate("3- 4 /2*   2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int index = 0;

        public int calculate(String s) {
            Deque<java.math.BigInteger> list = new LinkedList<>();
            int flag = 0;
            while (index < s.length()) {
                if (Character.isDigit(s.charAt(index))) {
                    if (flag == 0) {
                        list.addLast(readDigit(s, index));
                    } else if (flag == 1) {
                        list.addLast(readDigit(s, index).negate());
                    } else if (flag == 2) {
                        list.addLast(list.removeLast().multiply(readDigit(s, index)));
                    } else if (flag == 3) {
                        list.addLast(list.removeLast().divide(readDigit(s, index)));
                    }
                } else if (s.charAt(index) == '+') {
                    index++;
                    flag = 0;
                } else if (s.charAt(index) == '-') {
                    index++;
                    flag = 1;
                } else if (s.charAt(index) == '*') {
                    index++;
                    flag = 2;
                } else if (s.charAt(index) == '/') {
                    index++;
                    flag = 3;
                } else {
                    index++;
                }
            }
            int ret = 0;
            for (java.math.BigInteger bi : list) {
                ret += bi.intValue();
            }
            return ret;
        }

        private java.math.BigInteger readDigit(String s, int begin) {
            int end = begin;
            int i = begin;
            for (; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    break;
                }
            }
            end = i;
            index = i;
            return new java.math.BigInteger(s.substring(begin, end));
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