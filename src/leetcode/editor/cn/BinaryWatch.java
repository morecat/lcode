//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 👍 343 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        print(solution.readBinaryWatch(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            // 下面为枚举解法
//            Map<Integer, List<String>> map = new HashMap<>();
//            for (int h = 0; h < 12; h++) {
//                for (int m = 0; m < 60; m++) {
//                    int key = count(h) + count(m);
//                    List<String> res = map.get(key);
//                    if (res == null) {
//                        res = new ArrayList<>();
//                    }
//                    res.add("" + h + ":" + String.format("%02d", m));
//                    map.put(key, res);
//                }
//            }
//            List<String> r = map.get(turnedOn);
//            if (r == null) {
//                return new ArrayList<>();
//            } else {
//                return r;
//            }

            // 下列为回溯法解法
            List<String> res = new ArrayList<>();
            returnBack(0, 0, turnedOn, res);
            return res;
        }

        private void returnBack(int cache, int cnt, int turnedOn, List<String> res) {
            if (cnt == 10) {
                if (countBinary(cache) == turnedOn){
                    String time = printTime(cache);
                    res.add(time);
                }
                return;
            }
            int cache1 = cache | (0b0000000001 << cnt);
            if (((cache1 & 0b0000001111) < 12) && (((cache1 & 0b1111110000) >>> 4) < 60)) {
                returnBack(cache1, cnt + 1, turnedOn, res);
            }
            if (((cache & 0b0000001111) < 12) && (((cache & 0b1111110000) >>> 4) < 60)) {
                returnBack(cache, cnt + 1, turnedOn, res);
            }
        }

        private String printTime(int cache) {
            int hour = cache & 0b0000001111;
            int minute = (cache & 0b1111110000) >>> 4;
            return "" + hour + ":" + String.format("%02d", minute);
        }

        private int countBinary(int n) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += n & 0b0000000001;
                n >>>= 1;
            }
            return sum;
        }

        private int count(int i) {
            int sum = 0;
            int remain = i;
            while (remain != 0) {
                sum += remain % 2;
                remain /= 2;
            }
            return sum;
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