//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 845 👎 0

package leetcode.editor.cn;

import java.util.*;

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        print(solution.mySqrt(1));
        print(solution.mySqrt(2));
        print(solution.mySqrt(3));
        print(solution.mySqrt(4));
        print(solution.mySqrt(6));
        print(solution.mySqrt(9));
        print(solution.mySqrt(36));
        print(solution.mySqrt(2147395599));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long begin = 1;
        long end = x;
        long medium = (begin + end) / 2;
        while (begin <= end) {
            /*
             * 这里主要是要防止溢出，因为 2147395599 * 2147395599 的结果无法存放在 double中，
             * 因此将 (medium * medium) > x (其中medium >0) 改写为 medium > (x / medium)
             */
            double m = (double) x / (double) medium;
            double mp = (double) x / (double) (medium + 1);
            if (medium <= m && medium > mp) {
                return (int) medium;
            } else if (medium <= mp) {
                begin = medium + 1;
                medium = (begin + end) / 2;
            } else {
                end = medium - 1;
                medium = (begin + end) / 2;
            }
        }
        return (int) medium;
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