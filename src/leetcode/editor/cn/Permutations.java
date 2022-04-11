//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1908 👎 0

package leetcode.editor.cn;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        print(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> input = new ArrayList<>();
            for (int num : nums) {
                input.add(num);
            }
            return sort(input);
        }

        private List<List<Integer>> sort(List<Integer> list) {
            List<List<Integer>> r = new ArrayList<>();
            if (list.size() == 0) {
                return new ArrayList<>();
            }
            if (list.size() == 1) {
                r.add(list);
                return r;
            }
            for (int i = 0; i < list.size(); i++) {
                List<Integer> input = new ArrayList<>(list);
                int one = input.remove(i);
                List<List<Integer>> res = sort(input);
                for (List<Integer> l : res) {
                    l.add(0, one);
                }
                r.addAll(res);
            }
            return r;
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