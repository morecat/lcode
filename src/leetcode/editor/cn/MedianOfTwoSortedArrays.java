//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5298 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
//        print(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
//        print(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        print(solution.findMedianSortedArrays(new int[]{4, 5, 6, 8, 9}, new int[]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0, j = 0, k = 0;
            // 采用下面这种公式能保证在总数为奇数或者偶数的情况下都能得到正确的中位数值
            int l = (nums1.length + nums2.length - 1) / 2;
            int r = (nums1.length + nums2.length) / 2;
            int[] merged = new int[nums1.length + nums2.length];
            while ((i < nums1.length || j < nums2.length) && k - 1 < r) {
                if ((i < nums1.length && j < nums2.length) && (nums1[i] < nums2[j])) {
                    merged[k] = nums1[i];
                    i++;
                } else if ((i < nums1.length && j < nums2.length) && (nums1[i] >= nums2[j])) {
                    merged[k] = nums2[j];
                    j++;
                } else if (i < nums1.length) {
                    merged[k] = nums1[i];
                    i++;
                } else if (j < nums2.length) {
                    merged[k] = nums2[j];
                    j++;
                } else {
                    break;
                }
                k++;
            }
            return ((double) merged[l] + merged[r]) / 2;
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