//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 数学 👍 876 👎 0

package leetcode.editor.cn;

import java.util.*;

public class PlusOne{
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        print(solution.plusOne(new int[]{1, 2, 3}));
        System.out.println();
        print(solution.plusOne(new int[]{9, 9}));
        System.out.println();
        print(solution.plusOne(new int[]{9}));
        System.out.println();
        print(solution.plusOne(new int[]{1}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        /*
         * 这里result数组多申请了一位，用result[0]来存储进位标志carry，当循环结束时如果还有carry那么正好放置在result[0]的位置上
         * 这道题最关键的就是进位算法不能搞错
         * left = (本位加数srcLeft + 本位被加数add + 进位标志carry) % 10;
         * carry = (本位加数srcLeft + 本位被加数add + 进位标志carry) / 10;
         * 不要搞成下面这种
         * left = (srcLeft + carry) % 10;
         * carry = (srcLeft + add ) / 10;
         *
         * 第二点需要注意的是，进位值只可能处于0-9之间，因此result预留一个位置给最大的进位值是足够的
         */
        digits[digits.length - 1]++;
        int[] result = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i + 1] = (digits[i] + result[0]) % 10;
            result[0] = (digits[i] + result[0]) / 10;
        }
        if (result[0] == 0) {
            int[] newResult = new int[result.length - 1];
            System.arraycopy(result, 1, newResult, 0, newResult.length);
            return newResult;
        } else {
            return result;
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