//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 305 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LongestWordInDictionary {

    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
        print(solution.longestWord(new String[]{"gbra","jy","pl","zn","gb","j","jyh","jyhm","plr","znicn","p","gbr","zni","znic","aq"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            String result = "";
            Node node = new Node();
            for (String word : words) {
                node.insert(word);
            }
            for (String word : words) {
                if (node.search(word) && (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))) {
                    result = word;
                }
            }
            return result;
        }

        class Node {
            Node[] child = new Node[26];
            boolean isEnd = false;

            public void insert(String word) {
                Node n = this;
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (n.child[index] == null) {
                        n.child[index] = new Node();
                    }
                    n = n.child[index];
                }
                n.isEnd = true;
            }

            public boolean search(String word) {
                Node n = this;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (n.child[index] == null || !n.child[index].isEnd) {
                        return false;
                    } else {
                        n = n.child[index];
                    }
                }
                return true;
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