//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
//
// Related Topics 数组 二分查找 👍 1258 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;

public class FindPeakElement {

    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        print(solution.findPeakElement(new int[]{1, 3, 2, 5, 6, 7, 8, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            // 下面的是官方的题解，因为题目中指明数组两边都是极小值，
            // 而且所有元素值都不相同，那么数组中间一定能找到一个峰值，比如[1,2,3,4,5]的峰值是5
            int n = nums.length;
            int left = 0, right = n - 1, ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                    ans = mid;
                    break;
                }
                if (compare(nums, mid, mid + 1) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
        // 方便处理 nums[-1] 以及 nums[n] 的边界情况
        public int[] get(int[] nums, int idx) {
            if (idx == -1 || idx == nums.length) {
                return new int[]{0, 0};
            }
            return new int[]{1, nums[idx]};
        }

        public int compare(int[] nums, int idx1, int idx2) {
            int[] num1 = get(nums, idx1);
            int[] num2 = get(nums, idx2);
            if (num1[0] != num2[0]) {
                return num1[0] > num2[0] ? 1 : -1;
            }
            if (num1[1] == num2[1]) {
                return 0;
            }
            return num1[1] > num2[1] ? 1 : -1;
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