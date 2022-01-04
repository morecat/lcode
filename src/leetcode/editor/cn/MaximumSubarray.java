//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4139 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        print(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        print(solution.maxSubArray(new int[]{-1, -2}));
        print(solution.maxSubArray(new int[]{1}));
        print(solution.maxSubArray(new int[]{-1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        /*
         * 这道题需要使用动态规划求解
         * 设 f(i) 为以i结尾的最大子序列，则转移方程为 f(i+1)=max(f(i),num[i])
         */
        int result = Integer.MIN_VALUE;
        int[] cache = new int[nums.length];// 也可以将这个缓存区优化到O(1)，这里没做优化

        /*
         * 如果只有一个元素，那么转移方程就没有意义了
         */
        if (nums.length == 1){
            return nums[0];
        }

        /*
         * 初始化数据
         */
        cache[0] = nums[0];
        result = Math.max(cache[0], result);

        /*
         * 开始执行转移方程
         */
        for (int i = 1; i < nums.length; i++) {
            cache[i] = Math.max(cache[i - 1] + nums[i], nums[i]);
            result = Math.max(cache[i], result);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * O(n^3)的方法
     */
    public int maxSubArrayOld(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                result = Math.max(result, sum);
            }
        }
        return result;
    }

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

    private static void print(String str) {
        System.out.println(str);
    }

    private static void print(boolean[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(double[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(float[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(long[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(int[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static void print(Object[] arrays) {
        for (Object item : arrays) {
            System.out.println(item);
        }
    }

    private static <T> void print(Collection<T> collection) {
        for (T item : collection) {
            System.out.println(item);
        }
    }
}