//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1322 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;

public class MultiplyStrings {

    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        print(solution.multiply("2", "3"));
        print(solution.multiply("123", "456"));
        print(solution.multiply("9", "99"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < num1.length() + num2.length(); i++) {
                builder.append(0);
            }
            for (int i = 0; i < num1.length(); i++) {
                for (int j = 0; j < num2.length(); j++) {
                    int m1 = (num1.charAt(num1.length() - i - 1) - '0');
                    int m2 = (num2.charAt(num2.length() - j - 1) - '0');
                    update(builder, i + j, m1 * m2);
                }
            }
            builder.reverse();
            int begin = -1;
            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) != '0') {
                    begin = i;
                    break;
                }
            }
            if (begin == -1) {
                return "0";
            } else {
                return builder.substring(begin);
            }
        }

        private void update(StringBuilder builder, int index, int result) {
            int advance = 0;
            for (int i = index; i < builder.length(); i++) {
                if (result == 0 && advance == 0) {
                    return;
                }
                int low = result % 10;
                result /= 10;
                int sum = advance + low + (builder.charAt(i) - '0');
                builder.setCharAt(i, (char) (sum % 10 + '0'));
                advance = sum / 10;
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