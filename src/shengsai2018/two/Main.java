package shengsai2018.two;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/11.
 */
/*9数算式

观察如下的算式：
9213 x 85674 = 789314562

左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。

请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？

注意：
1. 总数目包含题目给出的那个示例。
2. 乘数和被乘数交换后作为同一方案来看待。
 */
public class Main {
    private static int COUNT = 0;

    /*
    思路:分层减少计算量，逐个判断
     */
    public static void main(String[] args) {
        // 1x8
        for (int x = 1; x <= 9; x++) {
            for (int y = 10; y <= 99999999; y++) {
                if (is9Number(x, y)) {
                    COUNT++;
                    System.out.println(x + "*" + y + "=" + (x * y));
                }
            }
        }

        // 2x7
        for (int x = 10; x <= 99; x++) {
            for (int y = 100; y <= 9999999; y++) {
                if (is9Number(x, y)) {
                    COUNT++;
                    System.out.println(x + "*" + y + "=" + (x * y));
                }
            }
        }
        // 3x6
        for (int x = 100; x <= 999; x++) {
            for (int y = 1000; y <= 999999; y++) {
                if (is9Number(x, y)) {
                    COUNT++;
                    System.out.println(x + "*" + y + "=" + (x * y));
                }
            }
        }
        // 4x5
        for (int x = 1000; x <= 9999; x++) {
            for (int y = 10000; y <= 99999; y++) {
                if (is9Number(x, y)) {
                    COUNT++;
                    System.out.println(x + "*" + y + "=" + (x * y));
                }
            }
        }
        System.out.println(COUNT);
    }

    private static boolean is9Number(int x, int y) {
        int result = x * y;
        if (!is0To9(result)) {
            return false;
        }
        if (!is0To9(x, y)) {
            return false;
        }
        return true;
    }

    private static boolean is0To9(int result) {
        return is0To9(String.valueOf(result));
    }

    private static boolean is0To9(int x, int y) {
        return is0To9(x + "" + y);
    }

    private static boolean is0To9(String number) {
        char[] numbers = String.valueOf(number).toCharArray();
        Set<Character> numberSet = new HashSet<>();
        for (char c : numbers) {
            // 1-9 不含0
            if (c == '0') {
                continue;
            }
            numberSet.add(c);
        }
        if (numberSet.size() != 9) {
            return false;
        }
        return true;
    }

}
