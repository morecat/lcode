package leetcode.editor.cn;

import java.util.*;

public class Main1 {

    public static class Trunk {
        int index;
        int size;

        public Trunk(){

        }

        public Trunk(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = 100;
        int used = 0;
        int free = total;
        List<Trunk> usedTrunk = new LinkedList<>();
        List<Trunk> freeTrunk = new LinkedList<>();
        freeTrunk.add(new Trunk(0, free));
        int num = Integer.parseInt(in.nextLine());
        for (int i =0 ;i<num;i++) {
            String line = in.nextLine();
            String[] parts = line.split("=");
            int size = Integer.parseInt(parts[1]);

            if ("REQUEST".equals(parts[0])) {
                // 检查空白块
                int index = -1;
                for (int j=0;j<freeTrunk.size();j++) {
                    Trunk trunk = freeTrunk.get(j);
                    if (trunk.size >= size) {
                        index = trunk.index;
                        trunk.index = size;
                        trunk.size -= size;
                        used += size;
                        free -= size;

                        usedTrunk.add(new Trunk(index,size));
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("error");
                } else {
                    System.out.println(index);
                }
            } else if ("RELEASE".equals(parts[0])) {
                int index = -1;
                for (int j=0;j<usedTrunk.size();j++) {
                    Trunk trunk = usedTrunk.get(j);
                    if (index == trunk.index) {
                        index = j;
                        break;
                    }
                }
                Trunk rt = usedTrunk.remove(index);
                for (int j=0;j<freeTrunk.size();j++) {
                    Trunk trunk = freeTrunk.get(j);
                    if (trunk.index == rt.index + size) {
                        trunk.index -= size;
                        trunk.size += size;
                        used -= size;
                        free += size;
                    }
                }

                if (index == -1) {
                    System.out.println("error");
                }
            } else {
                System.out.println("error");
            }
        }
    }
}
