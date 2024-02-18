//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2820 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
//        print(solution.minWindow("ADOBECODEBANC", "ABC"));
//        print(solution.minWindow("a", "a"));
//        print(solution.minWindow("a", "aa"));
//        print(solution.minWindow("aa", "a"));
        print(solution.minWindow("aa", "aa"));
//        print(solution.minWindow("abc", "cba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            Map<Character, Integer> finding = new HashMap<>();
            Map<Character, Integer> found = new HashMap<>();
            for (char c : t.toCharArray()) {
                add(finding, c);
            }
            String ret = "";
            int i = 0, j = 0;
            while (i < s.length()) {
                if (contains(finding, s.charAt(i))) {
                    remove(finding, s.charAt(i));
                    add(found, s.charAt(i));
                    j = i + 1;
                    break;
                }
                i++;
                j++;
            }
            if (isEmpty(finding)) {
                ret = s.substring(i, j);
            }
            while (j < s.length()) {
                if (isEmpty(finding) || contains(found, s.charAt(j))) {
                    if (isEmpty(finding)) {
                        String sub = s.substring(i, j);
                        if (ret.isEmpty() || sub.length() < ret.length()) {
                            ret = sub;
                        }
                    }
                    add(finding, s.charAt(i));
                    remove(found, s.charAt(i));
                    i++;
                    while (i < j) {
                        if (contains(found, s.charAt(i))) {
                            break;
                        }
                        i++;
                    }
                }
                if (contains(finding, s.charAt(j))) {
                    remove(finding, s.charAt(j));
                    add(found, s.charAt(j));
                }
                j++;
            }
            if (isEmpty(finding)) {
                String sub = s.substring(i, j);
                if (ret.isEmpty() || sub.length() < ret.length()) {
                    ret = sub;
                }
            }
            return ret;
        }

        private boolean isEmpty(Map<Character, Integer> map) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != null && entry.getValue() > 0) {
                    return false;
                }
            }
            return true;
        }

        private void add(Map<Character, Integer> map, Character character) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        private void remove(Map<Character, Integer> map, Character character) {
            map.put(character, map.getOrDefault(character, 0) - 1);
        }

        private boolean contains(Map<Character, Integer> map, Character character) {
            return map.getOrDefault(character, 0) != 0;
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