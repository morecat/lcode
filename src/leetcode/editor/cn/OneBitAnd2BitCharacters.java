//有两种特殊字符： 
//
// 
// 第一种字符可以用一比特 0 表示 
// 第二种字符可以用两比特（10 或 11）表示 
// 
//
// 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。 
//
// 
//
// 示例 1: 
//
// 
//输入: bits = [1, 0, 0]
//输出: true
//解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入：bits = [1,1,1,0]
//输出：false
//解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] 为 0 或 1 
// 
// Related Topics 数组 👍 279 👎 0

package leetcode.editor.cn;

import java.util.*;

public class OneBitAnd2BitCharacters {

    public static void main(String[] args) {
        Solution solution = new OneBitAnd2BitCharacters().new Solution();
        print(solution.isOneBitCharacter(new int[]{1, 0, 0}));
        print(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            boolean one = false;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == 1) {
                    one = false;
                    i++;
                } else {
                    one = true;
                }
            }
            return one;
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