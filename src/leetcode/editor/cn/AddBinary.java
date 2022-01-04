//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 720 👎 0

package leetcode.editor.cn;

import java.util.*;

public class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        print(solution.addBinary("11","1"));
        print(solution.addBinary("1","1"));
        print(solution.addBinary("0","1"));
        print(solution.addBinary("10","1"));
        print(solution.addBinary("0","0"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        if (a.length() < b.length()) {
            for (int i = 0; i < b.length() - a.length(); i++) {
                builder.append('0');
            }
            builder.append(a);
            a = builder.toString();
        } else {
            for (int i = 0; i < a.length() - b.length(); i++) {
                builder.append('0');
            }
            builder.append(b);
            b = builder.toString();
        }
        /*
         * 记住公式：
         * left = (本位加数srcLeft + 本位被加数add + 进位标志carry) % 10;
         * carry = (本位加数srcLeft + 本位被加数add + 进位标志carry) / 10;
         */
        int carry = 0;
        // 字符1 = (char)(数字1 + 48)
        for (int i = a.length() - 1; i >= 0; i--) {
            int sum = (a.charAt(i) - 48) + (b.charAt(i) - 48) + carry;
            result.insert(0, (char) (sum % 2 + 48));
            carry = sum / 2;
        }

        if (carry != 0) {
            result.insert(0, (char) (carry + 48));
        }
        return result.toString();
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