//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1624 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;

public class MaximalSquare {

    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        char[][] m1 = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        char[][] m2 = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };
        char[][] m3 = new char[][]{
                {'0', '1'}
        };
        char[][] m4 = new char[][]{
                {'0'},
                {'1'}
        };
        char[][] m5 = new char[][]{
                {'0'},
                {'0'}
        };
        char[][] m6 = new char[][]{
                {'0'}
        };
        char[][] m7 = new char[][]{
                {'1'}
        };
        print(solution.maximalSquare(m1));
        print(solution.maximalSquare(m2));
        print(solution.maximalSquare(m3));
        print(solution.maximalSquare(m4));
        print(solution.maximalSquare(m5));
        print(solution.maximalSquare(m6));
        print(solution.maximalSquare(m7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int height = matrix.length;
            int width = matrix[0].length;
            int min = Math.min(height, width);
            int ret = 0;
            int[][][] dp = new int[min][height][width];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    dp[0][h][w] = matrix[h][w] == '1' ? 1 : 0;
                    if (dp[0][h][w] == 1) {
                        ret = 1;
                    }
                }
            }
            for (int i = 2; i <= min; i++) {//i表示正方形边长
                for (int h = 0; h < height - i + 1; h++) {
                    // 官方解法中使用了很简单的方式，只用2层for循环，而且dp是二维数组，即dp[][]，
                    // dp[i][j]表示以 (i,j) 为右下角，且只包含1的正方形的边长最大值。
                    // 状态转移方程为dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                    for (int w = 0; w < width - i + 1; w++) {
                        dp[i - 1][h][w] = (matrix[h][w] == '1'
                                && dp[i - 2][h + 1][w] == 1
                                && dp[i - 2][h][w + 1] == 1
                                && dp[i - 2][h + 1][w + 1] == 1) ? 1 : 0;
                        if (dp[i - 1][h][w] == 1) {
                            ret = Math.max(ret, i);
                        }
                    }
                }
            }
            return ret * ret;
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