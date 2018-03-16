package shengsai2018.one;

/**
 * Created by Administrator on 2018/3/11.
 */

/*
 标题：迷宫

 X星球的一处迷宫游乐场建在某个小山坡上。
 它是由10x10相互连通的小房间组成的。

 房间的地板上写着一个很大的字母。
 我们假设玩家是面朝上坡的方向站立，则：
 L表示走到左边的房间，
 R表示走到右边的房间，
 U表示走到上坡方向的房间，
 D表示走到下坡方向的房间。

 X星球的居民有点懒，不愿意费力思考。
 他们更喜欢玩运气类的游戏。这个游戏也是如此！

 开始的时候，直升机把100名玩家放入一个个小房间内。
 玩家一定要按照地上的字母移动。

 迷宫地图如下：
 ------------
 UDDLUULRUL
 UURLLLRRRU
 RRUURLDLRD
 RUDDDDUUUU
 URUDLLRRUU
 DURLRLDLRL
 ULLURLLRDU
 RDLULLRDDD
 UUDDUDUDLL
 ULRDLUURRR
 ------------

 请你计算一下，最后，有多少玩家会走出迷宫?
 而不是在里边兜圈子。

 */
public class Main {
    // 计数
    private static int COUNT = 0;
    private static char[][] map = initMap();
    private static boolean[][] way = new boolean[10][10];

    public static void main(String[] args) {

        /*
         分析:
         只要是回路上出现的点，都走不出去
          */

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                initWay();
                dfs(i, j);
            }
        }
        System.out.println(COUNT);
    }

    private static void initWay() {
        for (int q = 0; q < 10; q++) {
            for (int w = 0; w < 10; w++) {
                way[q][w] = false;
            }
        }
    }

    /*
      深度优先遍历每个点，新建一个二维数组，遍历到的点标记为true
    */
    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x > 9 || y > 9) {
            COUNT++;
            return;
        }
        if (way[x][y]) {
            return;
        }
        way[x][y] = true;
        switch (map[x][y]) {
            case 'U':
                dfs(x - 1, y);
                break;
            case 'D':
                dfs(x + 1, y);
                break;
            case 'R':
                dfs(x, y + 1);
                break;
            case 'L':
                dfs(x, y - 1);
                break;
        }
    }

    private static char[][] initMap() {
        // format String to Array
        char[][] map = new char[10][10];
        String mapStr = "UDDLUULRUL\n" +
                "UURLLLRRRU\n" +
                "RRUURLDLRD\n" +
                "RUDDDDUUUU\n" +
                "URUDLLRRUU\n" +
                "DURLRLDLRL\n" +
                "ULLURLLRDU\n" +
                "RDLULLRDDD\n" +
                "UUDDUDUDLL\n" +
                "ULRDLUURRR";
        String[] line = mapStr.split("\n");
        for (int i = 0; i < line.length; i++) {
            String mapLine = line[i];
            char[] mapChar = mapLine.toCharArray();
            for (int j = 0; j < mapChar.length; j++) {
                map[i][j] = mapChar[j];
            }
        }
        return map;
    }
}
