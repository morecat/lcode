//给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。 
//
// 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,1,0]
//输出：1
//解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：-1
//解释：4 没有超过 3 的两倍大，所以返回 -1 。 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
//解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 100 
// nums 中的最大元素是唯一的 
// 
// Related Topics 数组 排序 👍 171 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
        print(solution.dominantIndex(new int[]{3, 6, 1, 0}));
        print(solution.dominantIndex(new int[]{1, 2, 3, 4}));
        print(solution.dominantIndex(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 维护两个变量，进行一次遍历来查找数组中的最大值和次大值
         */
        public int dominantIndex(int[] nums) {
            int m1 = -1, m2 = -1;
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > m1) {
                    m2 = m1;
                    m1 = nums[i];
                    index = i;
                } else if (nums[i] > m2) {
                    m2 = nums[i];
                }
            }
            return m1 >= m2 * 2 ? index : -1;
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