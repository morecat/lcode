//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1046 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int i = 0, j = 0, snapI = i, snapJ = j;
            do {
                snapI = i;
                snapJ = j;
                while (canTravel(matrix, i, j + 1)) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    j++;
                }
                while (canTravel(matrix, i + 1, j)) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    i++;
                }
                while (canTravel(matrix, i, j - 1)) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    j--;
                }
                while (canTravel(matrix, i - 1, j)) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    i--;
                }
            } while (i != snapI || j != snapJ);
            res.add(matrix[i][j]);
            return res;
        }

        private boolean canTravel(int[][] matrix, int i, int j) {
            return i >= 0 && j >= 0 && i < matrix.length &&
                    j < matrix[0].length && matrix[i][j] != Integer.MAX_VALUE;
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