//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 滑动窗口 👍 355 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        print(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        print(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        print(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 官方解法有3：
     * 1 滑动窗口，移动一个固定大小的窗口，在窗口内线性搜索
     * 2 滑动窗口+BST，提升在窗口中的搜索效率
     * 3 hash，遍历的同时进行判断和存储
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer imap = hashMap.get(nums[i]);
            if (imap != null && i - imap <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
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