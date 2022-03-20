//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 313 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{1, 1, 1, 1};
        print(solution.findLHS(nums));
        print(solution.findLHS(nums1));
        print(solution.findLHS(nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 这道题看似复杂，其实核心意思很简单
         * 就是在数组中找到两个大小上相邻的数字（相邻数字的差值为1）
         * 然后统计这两个相邻数字组成的数组最大能有多长
         */
        public int findLHS(int[] nums) {
            return func2(nums);
        }

        /**
         * 1. 排序 + 滑动窗口
         * 先针对数组进行排序，然后采用滑动窗口划过整个数组，找到满足条件的最大窗口
         */
        public int func1(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int begin = 0;
            // 不管窗口中的数据是否满足条件，窗口的右边界都要前进
            // 当窗口偏大时，要收缩左边界
            for (int end = 0; end < nums.length; end++) {
                while (nums[end] - nums[begin] > 1) {
                    begin++;
                }
                if (nums[end] - nums[begin] == 1) {
                    res = Math.max(res, end - begin + 1);
                }
            }
            return res;
        }

        /**
         * 2. Hash + 计数
         */
        public int func2(int[] nums) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer count = map.get(num);
                if (count == null) {
                    count = 0;
                }
                map.put(num, count + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer nextCount = map.get(entry.getKey() + 1);
                if (nextCount != null) {
                    res = Math.max(res, entry.getValue() + nextCount);
                }
            }
            return res;
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