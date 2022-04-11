package leetcode.editor.cn;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str = "42";
        String str1 = "2147483647";
        String str2 = "-2147483648";

//        System.out.println(atoi(str));
//        System.out.println(atoi(str1));
        System.out.println(atoi(str2));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int atoi(String str) {
        int begin = 0;
        boolean negative = false;
        if (str.startsWith("-")) {
            begin++;
            negative = true;
        }
        int sum = 0;
        for (int i = begin; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            sum *= 10;
            if (negative) {
                sum -= num;
            } else {
                sum += num;
            }
        }
        return sum;
    }

}