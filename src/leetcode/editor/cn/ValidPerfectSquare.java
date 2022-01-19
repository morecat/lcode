//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 341 👎 0

package leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.*;

public class ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        print(solution.isPerfectSquare(1));
        print(solution.isPerfectSquare(2));
        print(solution.isPerfectSquare(3));
        print(solution.isPerfectSquare(4));
        print(solution.isPerfectSquare(8));
        print(solution.isPerfectSquare(14));
        print(solution.isPerfectSquare(16));
        print(solution.isPerfectSquare(808201));
        print(solution.isPerfectSquare(2147483647));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long begin = 1;
        long end = num / 2;
        long mid = (begin + end) / 2;
        while (begin <= end) {
            double div = (double) num / mid;
            double abs = (div > mid) ? (div - mid) : (mid - div);
            if (abs < 0.001) { //这个误差值如果选择0.1会出现错误, 这里的值我是猜的
                return true;
            } else if (div > mid) {
                begin = mid + 1;
                mid = (begin + end) / 2;
            } else {
                end = mid - 1;
                mid = (begin + end) / 2;
            }
        }
        return false;
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