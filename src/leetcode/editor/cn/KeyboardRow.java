//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 200 👎 0

package leetcode.editor.cn;

import java.util.*;

public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
        print(solution.findWords(new String[]{"Hello","Alaska","Dad","Peace"}));
        print(solution.findWords(new String[]{"omk"}));
        print(solution.findWords(new String[]{"adsdf","sfd"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Set<Character> map1 = new HashSet<>();
        private final Set<Character> map2 = new HashSet<>();
        private final Set<Character> map3 = new HashSet<>();

        public String[] findWords(String[] words) {
            List<String> res = new ArrayList<>();
            for (char c : "qwertyuiop".toCharArray()) {
                map1.add(c);
            }
            for (char c : "asdfghjkl".toCharArray()) {
                map2.add(c);
            }
            for (char c : "zxcvbnm".toCharArray()) {
                map3.add(c);
            }
            for (String ostr : words) {
                String str = ostr.toLowerCase();
                if (map1.contains(str.charAt(0))) {
                    boolean flag = true;
                    for (char c : str.toCharArray()) {
                        if (!map1.contains(c)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res.add(ostr);
                    }
                } else if (map2.contains(str.charAt(0))) {
                    boolean flag = true;
                    for (char c : str.toCharArray()) {
                        if (!map2.contains(c)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res.add(ostr);
                    }
                } else if (map3.contains(str.charAt(0))) {
                    boolean flag = true;
                    for (char c : str.toCharArray()) {
                        if (!map3.contains(c)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res.add(ostr);
                    }
                }
            }
            return res.toArray(new String[0]);
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