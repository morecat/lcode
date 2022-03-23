//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。 
//
// 如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 2³¹ - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 251 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        TreeNode root1 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = null;
        TreeNode root4 = new TreeNode(2, new TreeNode(2), new TreeNode(5));
        print(solution.findSecondMinimumValue(root));
        print(solution.findSecondMinimumValue(root1));
        print(solution.findSecondMinimumValue(root2));
        print(solution.findSecondMinimumValue(root3));
        print(solution.findSecondMinimumValue(root4));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        public int findSecondMinimumValue(TreeNode root) {
//            return dfs(root, 1, 2);
            priorityQueue = new PriorityQueue<>((a, b) -> b - a);
            dfs1(root);
            return priorityQueue.size() < 2 ? -1 : priorityQueue.poll();
        }

        public void dfs1(TreeNode node) {
            if (node == null) {
                return;
            }
            if (!priorityQueue.contains(node.val)) {
                priorityQueue.offer(node.val);
            }
            if (priorityQueue.size() > 2) {
                priorityQueue.poll();
            }
            dfs1(node.left);
            dfs1(node.right);
        }

        /**
         * 本来是想做个能查询第k小的数的函数，不过函数逻辑有问题
         * 仅仅遍历左子树或者右子树是没法获得一个全局的信息的，而排序需要全局进行一个参与，比如
         * 1
         * | \
         * 2  1
         * |\ |\
         * 26 13
         *
         * @param node    当前节点
         * @param counter 计数器
         * @param target  第k小的数
         */
        private int dfs(TreeNode node, int counter, int target) {
            if (node == null) {
                return -1;
            }
            if (counter == target) {
                return node.val;
            }
            if (node.left == null || node.right == null) {
                return -1;
            }
            if (node.val != node.left.val) {
                return dfs(node.left, counter + 1, target);
            } else {
                if (node.val != node.right.val) {
                    counter++;
                }
                return dfs(node.right, counter, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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