//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1241 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 3));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 6));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        print(solution.searchInsert(new int[]{1, 3, 5, 6}, -1));
        print(solution.searchInsert(new int[]{}, -1));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        int medium = (end - begin) / 2;
        while (begin < end) {
            if (nums[medium] == target) {
                return medium;
            } else if (nums[medium] > target) {
                end = medium;
            } else {
                // 定理: [取底(x*2+1)/2]=x，注意 [取底(x*2-1)/2]=x不成立!
                // 关键点1：当出现begin等于end-1的情况时，此处错误的写法是begin=medium;这种写法将导致死循环，
                // 原因是 当出现begin等于end-1的情况时，可以证明medium等于begin，证明如下：
                // 由于begin等于end-1，medium等于(end+begin)/2等于(2*begin+1)/2等于begin，即medium等于begin
                // 此时 begin，end等于begin+1，medium等于begin，如果再令begin=medium，那么将导致begin,medium,end这3项数值不发生变化，进而陷入死循环
                begin = medium + 1;
            }
            // 关键点2：这里注意不要写成 medium = (end - begin) / 2;
            medium = (end + begin) / 2;
        }
        return medium;
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