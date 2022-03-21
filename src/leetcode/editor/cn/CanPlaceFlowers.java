//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心 数组 👍 438 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();
        print(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        print(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        print(solution.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
        print(solution.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        print(solution.canPlaceFlowers(new int[]{1, 0, 1, 0, 0}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int counter = 0;
            int tmp = 1;
            for (int item : flowerbed) {
                if (item == 0) {
                    tmp++;
                } else {
                    if (tmp != 0) {
                        counter += (tmp - 1) / 2;
                        tmp = 0;
                    }
                }
            }
            if (tmp != 0) {
                counter += tmp / 2;
            }
            return counter >= n;
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

}