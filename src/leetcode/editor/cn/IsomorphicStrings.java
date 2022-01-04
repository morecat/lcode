//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 字符串 👍 415 👎 0

package leetcode.editor.cn;

import java.util.*;

public class IsomorphicStrings{
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        print(solution.isIsomorphic("egg", "add"));
        print(solution.isIsomorphic("foo", "bar"));
        print(solution.isIsomorphic("paper", "title"));
        print(solution.isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (char c : s.toCharArray()) {
            Integer i = map1.get(c);
            if (i == null) {
                i = map1.size();
                map1.put(c, i);
            }
            stringBuilder1.append(i).append(" ");
        }
        for (char c : t.toCharArray()) {
            Integer i = map2.get(c);
            if (i == null) {
                i = map2.size();
                map2.put(c, i);
            }
            stringBuilder2.append(i).append(" ");
        }
        return stringBuilder1.toString().equals(stringBuilder2.toString());
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