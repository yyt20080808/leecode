package Array;

import java.util.HashSet;

/**
 * Created by yyt on 2018/1/23.
 */

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island
// is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        11110
//        11010
//        11000
//        00000
//        Answer: 1
//
//        Example 2:
//
//        11000
//        11000
//        00100
//        00011
//        Answer: 3
public class NumberOfIslands {
    // 我感觉这是一个 UF问题
    public NumberOfIslands() {

    }

    public int numIslands(char[][] grid) {

        int M = grid.length;
        if (M == 0)
            return 0;
        int N = grid[0].length;
        if (N == 0)
            return 0;
        int[][] x = new int[M][N];
        int count = 0;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (grid[i][j] == '1') {
                    if ((i > 0 && grid[i - 1][j] == '1'))
                        x[i][j] = x[i - 1][j];
                    else if ((j > 0 && grid[i][j - 1] == '1')) {
                        x[i][j] = x[i][j - 1];
                    } else {
                        x[i][j] = ++count;
                    }

                }
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i][j] > 0 && x[i + 1][j] > 0 && x[i][j] != x[i + 1][j])
                    uf( x, x[i][j], x[i + 1][j] );
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (x[i][j] > 0 && x[i][j + 1] > 0 && x[i][j] != x[i][j + 1])
                    uf( x, x[i][j], x[i][j + 1] );
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1')
                    set.add( x[i][j] );
            }
        }
        return set.size();
    }

    private void uf(int[][] x, int a, int b) {
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < x[0].length; j++)
                if (x[i][j] == b)
                    x[i][j] = a;
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '1', '1',}, {'0', '1', '0'}, {'1', '1', '1'}};
//        , {'1', '0', '0', '0', '1','0'}}
//        char[][] a = {{'1', '1', '0', '1', '0','1'}, {'1', '0', '1', '1', '1','0'}
//        , {'1', '0', '0', '0', '1','0'},
//                {'0', '1', '0', '0','0', '1'}};
        NumberOfIslands n = new NumberOfIslands();
        n.numIslands( a );
    }
}
