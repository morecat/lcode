//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1937 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"a"};
        print(solution.longestCommonPrefix(strs));
        print(solution.longestCommonPrefix(strs1));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        int i = 0;
        outter:
        while (true) {
            if (strs[0].length() <= i) {
                break;
            }
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length()) {
                    break outter;
                }
                if (str.charAt(i) != c) {
                    break outter;
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
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