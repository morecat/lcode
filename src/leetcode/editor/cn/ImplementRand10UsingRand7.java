////给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
////
//// 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
////
////
////
////
//// 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
////
////
////
//// 示例 1:
////
////
////输入: 1
////输出: [2]
////
////
//// 示例 2:
////
////
////输入: 2
////输出: [2,8]
////
////
//// 示例 3:
////
////
////输入: 3
////输出: [3,8,10]
////
////
////
////
//// 提示:
////
////
//// 1 <= n <= 10⁵
////
////
////
////
//// 进阶:
////
////
//// rand7()调用次数的 期望值 是多少 ?
//// 你能否尽量少调用 rand7() ?
////
////
//// Related Topics 数学 拒绝采样 概率与统计 随机化 👍 476 👎 0
//
//package leetcode.editor.cn;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//public class ImplementRand10UsingRand7 {
//
//    public static void main(String[] args) {
//        Solution solution = new ImplementRand10UsingRand7().new Solution();
//    }
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//    /**
//     * The rand7() API is already defined in the parent class SolBase.
//     * public int rand7();
//     *
//     * @return a random integer in the range 1 to 7
//     */
//    class Solution extends SolBase {
//        public int rand10() {
//            int row, col, idx;
//            do {
//                row = rand7();
//                col = rand7();
//                idx = col + (row - 1) * 7;
//            } while (idx > 40);
//            return 1 + (idx - 1) % 10;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//
//    private static void print(boolean b) {
//        System.out.println(b);
//    }
//
//    private static void print(double d) {
//        System.out.println(d);
//    }
//
//    private static void print(float f) {
//        System.out.println(f);
//    }
//
//    private static void print(long l) {
//        System.out.println(l);
//    }
//
//    private static void print(int i) {
//        System.out.println(i);
//    }
//
//    private static void print(byte i) {
//        System.out.println(i);
//    }
//
//    private static void print(char i) {
//        System.out.println(i);
//    }
//
//    private static void print(short i) {
//        System.out.println(i);
//    }
//
//    private static void print(String str) {
//        System.out.println(str);
//    }
//
//    private static void print(boolean[] arrays) {
//        for (boolean item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(double[] arrays) {
//        for (double item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(float[] arrays) {
//        for (float item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(long[] arrays) {
//        for (long item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(int[] arrays) {
//        for (int item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(char[] arrays) {
//        for (char item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(Object[] arrays) {
//        for (Object item : arrays) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static <T> void print(Collection<T> collection) {
//        for (T item : collection) {
//            System.out.print(item + " ");
//        }
//        System.out.println();
//    }
//
//    private static void print(int[][] arrays) {
//        for (int[] item : arrays) {
//            System.out.println(Arrays.toString(item));
//        }
//        System.out.println();
//    }
//
//    private static void print(String[][] arrays) {
//        for (String[] item : arrays) {
//            System.out.println(Arrays.toString(item));
//        }
//        System.out.println();
//    }
//}