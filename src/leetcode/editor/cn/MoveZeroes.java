//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 👍 1381 👎 0

package leetcode.editor.cn;

import java.util.*;

public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] src0 = new int[]{0,0,1};
        int[] src = new int[]{0,1,0,3,12};
        int[] src1 = new int[]{0,0,0,0,0};
        int[] src2 = new int[]{1,2,3,4,5};
        int[] src3 = new int[]{1};
        int[] src4 = new int[]{0};
        int[] src5 = new int[]{};
        solution.moveZeroes(src0);
        solution.moveZeroes(src);
        solution.moveZeroes(src1);
        solution.moveZeroes(src2);
        solution.moveZeroes(src3);
        solution.moveZeroes(src4);
        solution.moveZeroes(src5);
        print(src0);
        print(src);
        print(src1);
        print(src2);
        print(src3);
        print(src4);
        print(src5);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void moveZeroes(int[] nums) {
        int end = nums.length;
        for (int i = 0; i < end; i++) {
            if (nums[i] == 0) {
                System.arraycopy(nums, i + 1, nums, i, end - i - 1);
                nums[--end] = 0;
                i--;
            }
        }
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