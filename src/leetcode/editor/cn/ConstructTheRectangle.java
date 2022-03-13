//作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 所以，现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下
//要求的矩形的页面。要求： 
//
// 
// 你设计的矩形页面必须等于给定的目标面积。 
// 宽度 W 不应大于长度 L ，换言之，要求 L >= W 。 
// 长度 L 和宽度 W 之间的差距应当尽可能小。 
// 
//
// 返回一个 数组 [L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。 
// 
//
// 示例1： 
//
// 
//输入: 4
//输出: [2, 2]
//解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
//但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
// 
//
// 示例 2: 
//
// 
//输入: area = 37
//输出: [37,1]
// 
//
// 示例 3: 
//
// 
//输入: area = 122122
//输出: [427,286]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= area <= 10⁷ 
// 
// Related Topics 数学 👍 114 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ConstructTheRectangle {
    public static void main(String[] args) {
        Solution solution = new ConstructTheRectangle().new Solution();
        print(solution.constructRectangle(4));
        print(solution.constructRectangle(3));
        print(solution.constructRectangle(2));
        print(solution.constructRectangle(1));
        print(solution.constructRectangle(37));
        print(solution.constructRectangle(122122));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructRectangle(int area) {
            int ll = area;
            int ww = 1;
            for (int l = area; l >= Math.pow(area,0.5D); l--) {
                if ((area % l == 0) && (l >= area / l) && (l - area / l < ll - ww)) {
                    ll = l;
                    ww = area / l;
                }
            }
            return new int[]{ll, ww};
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