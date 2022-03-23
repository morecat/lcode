//在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。 
//
// 移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。 
//
// 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。 
//
// 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。 
//
// 
//
// 示例 1: 
//
// 
//输入: moves = "UD"
//输出: true
//解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。 
//
// 示例 2: 
//
// 
//输入: moves = "LL"
//输出: false
//解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。 
//
// 
//
// 提示: 
//
// 
// 1 <= moves.length <= 2 * 10⁴ 
// moves 只包含字符 'U', 'D', 'L' 和 'R' 
// 
// Related Topics 字符串 模拟 👍 225 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RobotReturnToOrigin {

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new RobotReturnToOrigin().new Solution();
        print(solution.judgeCircle("UD"));
        print(solution.judgeCircle("LL"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeCircle(String moves) {
            int countV = 0;
            int countH = 0;
            for (char c : moves.toCharArray()) {
                switch (c) {
                    case 'U':
                        countV++;
                        break;
                    case 'D':
                        countV--;
                        break;
                    case 'L':
                        countH++;
                        break;
                    case 'R':
                        countH--;
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
            return countV == 0 && countH == 0;
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