//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 945 👎 0

package leetcode.editor.cn;

import java.util.*;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
//        print(solution.diameterOfBinaryTree(root));
        print(solution.diameterOfBinaryTree(root1));
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

        int maxRoute = 0;

        /**
         * 虽然最大路径长度不一定经过根节点，但是一定会通过其中某个子树的根节点
         * 因此把所有子树的“当前子树通过根节点的最大路径长”都计算出来，然后比较最大值即可
         * “当前子树通过根节点的最大路径长” = 左子树高度 + 右子树高度 + 2
         */
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return 0;
            }
            travelAllNode(root);
            return maxRoute;
        }

        /**
         * 遍历所有节点，并获取“通过每个的节点的最大路径长”，然后取最大值
         */
        private void travelAllNode(TreeNode node) {
            if (node == null) {
                return;
            }
            maxRoute = Math.max(maxRoute, maxRouteCrossNode(node));
            travelAllNode(node.left);
            travelAllNode(node.right);
        }

        /**
         * 获取通过当前节点的最大路径长度
         */
        private int maxRouteCrossNode(TreeNode node) {
            if (node.left == null && node.right == null) {
                return 0;
            }
            int sum = 0;
            if (node.left != null) {
                sum += deepOfTree(node.left) + 1;
            }
            if (node.right != null) {
                sum += deepOfTree(node.right) + 1;
            }
            return sum;
        }

        /**
         * 获取树的高度
         */
        private int deepOfTree(TreeNode node) {
            if (node == null || (node.left == null && node.right == null)) {
                return 0;
            }
            return Math.max(deepOfTree(node.left), deepOfTree(node.right)) + 1;
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

}