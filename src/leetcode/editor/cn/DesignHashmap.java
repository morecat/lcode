//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 10⁶ 
// 最多调用 10⁴ 次 put、get 和 remove 方法 
// 
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 300 👎 0

package leetcode.editor.cn;

import java.util.*;

public class DesignHashmap {

    public static void main(String[] args) {
        MyHashMap map = new DesignHashmap().new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        map.get(1);
        map.get(3);
        map.put(2, 1);
        map.get(2);
        map.remove(2);
        map.get(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private Node[] buckets = new Node[1024];

        class Node {
            private int key;

            private int val;
            private Node next;

            public Node() {
            }

            public Node(int key, int val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        private Node findBucket(int key) {
            return buckets[Objects.hashCode(key) % buckets.length];
        }

        private void setBucket(Node node, int key) {
            buckets[Objects.hashCode(key) % buckets.length] = node;
        }

        private Node insertNode(Node header, int key, int val) {
            if (header == null) {
                return new Node(key, val, null);
            } else {
                Node prev = null;
                Node curr = header;
                Node found = null;
                while (curr != null) {
                    if (curr.key == key) {
                        found = curr;
                        break;
                    }
                    prev = curr;
                    curr = curr.next;
                }
                if (found == null) {
                    prev.next = new Node(key, val, null);
                } else {
                    found.val = val;
                }
                return header;
            }
        }

        private Node findNode(Node header, int val) {
            Node curr = header;
            while (curr != null) {
                if (curr.key == val) {
                    return curr;
                }
                curr = curr.next;
            }
            return curr;
        }

        private Node removeNode(Node header, int key) {
            Node prev = null;
            Node curr = header;
            while (curr != null) {
                if (curr.key == key) {
                    if (curr == header) {
                        return curr.next;
                    } else {
                        prev.next = curr.next;
                        return header;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
            return header;
        }

        public MyHashMap() {

        }

        public void put(int key, int value) {
            Node header = findBucket(key);
            if (header == null) {
                setBucket(new Node(key, value, null), key);
            } else {
                setBucket(insertNode(header, key, value), key);
            }
        }

        public int get(int key) {
            Node header = findBucket(key);
            if (header == null) {
                return -1;
            } else {
                Node node = findNode(header, key);
                if (node == null) {
                    return -1;
                } else {
                    return node.val;
                }
            }
        }

        public void remove(int key) {
            Node header = findBucket(key);
            if (header != null) {
                Node newHeader = removeNode(header, key);
                if (newHeader != header) {
                    setBucket(newHeader, key);
                }
            }
        }


    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
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