package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Eight {

    // 八皇后问题
    public static void main(String[] args) {
        recursive(new int[8][8], new LinkedList<>(), 0);
    }

    private static void recursive(int[][] matrix, Deque<String> tmp, int cnt) {
        if (cnt == matrix.length) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (isDup(matrix, cnt, i)) {
                continue;
            }
            matrix[cnt][i] = 1;
            tmp.push(cnt + "," + i);
            recursive(matrix, tmp, cnt + 1);
            tmp.pop();
            matrix[cnt][i] = 0;
        }
    }


    private static boolean isDup(int[][] matrix, int x, int y) {
        for (int[] ints : matrix) {
            if (ints[y] == 1) {
                return true;
            }
        }
        for (int k : matrix[x]) {
            if (k == 1) {
                return true;
            }
        }
        int i = 0;
        while (x + i < 8 && y + i < 8) {
            if (matrix[x + i][y + i] == 1) {
                return true;
            }
            i++;
        }
        i = 0;
        while (x + i < 8 && y - i >= 0) {
            if (matrix[x + i][y - i] == 1) {
                return true;
            }
            i++;
        }
        i = 0;
        while (x - i >= 0 && y + i < 8) {
            if (matrix[x - i][y + i] == 1) {
                return true;
            }
            i++;
        }
        i = 0;
        while (x - i >= 0 && y - i >= 0) {
            if (matrix[x - i][y - i] == 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
