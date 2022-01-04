//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 👍 488 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ExcelSheetColumnTitle{
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        print(solution.convertToTitle(1));
        print(solution.convertToTitle(26));
        print(solution.convertToTitle(27));
        print(solution.convertToTitle(701));
        print(solution.convertToTitle(2147483647));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        /*
         * 1 -> 1(26) -> 1 ->A
         * 25 -> 25(26) -> 25 -> Y
         * 26 -> 1 0(26) -> 26 -> Z
         * 27 -> 1 1(26) -> 1 0 -> AA
         *
         * 这道题主要是需要2次转换，第一次就是普通的进制转换，第二次需要把进制转换为字母
         * 难点在于第一次转换结果和第二次转换结果不对齐，因此第一次转换结果需要处理
         */
        StringBuilder builder = new StringBuilder();
        int division = columnNumber;
        int mod;
        do {
            mod = division % 26;
            division = division / 26;
            if (mod == 0) {
                division -= 1;
                mod = 26;
            }
            builder.insert(0, (char) ('A' + mod - 1));
        } while ((division != 0));
        return builder.toString();
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