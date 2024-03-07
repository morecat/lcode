//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2059 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        print(solution.minSubArrayLen(100, new int[]{2, 3, 1, 2, 4, 3}));
        print(solution.minSubArrayLen(1, new int[]{2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0, j = 1;
            int ret = Integer.MAX_VALUE;
            int sum = nums[0];
            while (j <= nums.length) {
                if (sum >= target) {
                    ret = Math.min(ret, j - i);
                    if (i == j - 1) {
                        if (j < nums.length) {
                            sum += nums[j];
                        }
                        j++;
                    } else {
                        sum -= nums[i];
                        i++;
                    }
                } else {
                    if (j < nums.length) {
                        sum += nums[j];
                    }
                    j++;
                }
            }
            return ret == Integer.MAX_VALUE ? 0 : ret;
        }

        /**
         * 前缀和+二分查找 解法：
         *
         * 我们申请一个临时数组 sums，其中 sums[i] 表示的是原数组 nums 前 i 个元素的和，
         * 题中说了 “给定一个含有 n 个 正整数 的数组”，既然是正整数，那么相加的和会越来越大，
         * 也就是sums数组中的元素是递增的。我们只需要找到 sums[k]-sums[j]>=s，那么 k-j 就是满足的连续子数组，
         * 但不一定是最小的，所以我们要继续找，直到找到最小的为止。怎么找呢，我们可以使用两个 for 循环来枚举，
         * 但这又和第一种暴力求解一样了，所以我们可以换种思路，求 sums[k]-sums[j]>=s 我们可以求 sums[j]+s<=sums[k]，
         * 那这样就好办了，因为数组sums中的元素是递增的，也就是排序的，我们只需要求出 sum[j]+s 的值，
         * 然后使用二分法查找即可找到这个 k。
         *
         * 作者：数据结构和算法
         * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/306066/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

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