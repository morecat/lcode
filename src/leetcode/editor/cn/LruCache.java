//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2043 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LruCache {


    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LruCache().new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        /**
         * 最重要的是要构建一个双向链表
         * 主要是在get()中移动节点到头的过程中需要找到前一个节点
         */
        class Node {
            /**
             * 是为了移除尾节点时能够在hash中快速查找
             */
            private int key;
            /**
             * 是为了返回存储的实际数值
             */
            private int val;
            private Node next;
            private Node prev;
        }

        Map<Integer, Node> hashMap;
        /**
         * 使用假头节点的原因是“在get()中需要将节点移动到链表头，且移动的节点恰好是真头节点，如果没有假头那么node.prev.next将抛出NPE”
         */
        Node fakeHeader;
        /**
         * 使用假尾节点的原因是"在put()方法中需要淘汰尾节点"
         */
        Node fakeTailer;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>();
            fakeHeader = new Node();
            fakeTailer = new Node();
            fakeHeader.key = -1;
            fakeTailer.key = -2;
            fakeHeader.next = fakeTailer;
            fakeTailer.prev = fakeHeader;
        }

        public int get(int key) {
            Node node = hashMap.get(key);
            if (node == null) {
                return -1;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = fakeHeader.next;
            node.prev = fakeHeader;
            fakeHeader.next.prev = node;
            fakeHeader.next = node;

            return node.val;
        }

        public void put(int key, int value) {
            // 如果key存在，那么更新Node的val，更新Node在链表中的位置
            Node node = hashMap.get(key);
            if (node != null) {
                node.val = value;
                // 移除node原来所在的位置
                Node prev = node.prev;
                Node next = node.next;
                next.prev = node.prev;
                prev.next = node.next;
            } else {
                // 新建节点
                node = new Node();
                node.key = key;
                node.val = value;
                hashMap.put(key, node);
            }
            // 插入
            node.next = fakeHeader.next;
            node.prev = fakeHeader;
            fakeHeader.next.prev = node;
            fakeHeader.next = node;

            // 移除超容量节点
            if (hashMap.size() > capacity) {
                Node toRemove = fakeTailer.prev;
                toRemove.next.prev = toRemove.prev;
                toRemove.prev.next = fakeTailer;
                hashMap.remove(toRemove.key);
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
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