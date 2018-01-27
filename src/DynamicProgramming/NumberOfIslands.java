package DynamicProgramming;

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
        boolean[][] isVisited = new boolean[M][N];
        int count = 0;
        for (int i = 0; i < M ; i++)
            for (int j = 0; j < N; j++)
                if(grid[i][j]=='1' && !isVisited[i][j]){
                    dfs( grid,isVisited,i,j );
                    count++;
                }
        return count;
    }

    private void dfs(char[][] grid,boolean[][] isVisited, int a, int b) {
        int M = grid.length;
        int N = grid[0].length;
        if(a < 0 || a >= M || b < 0|| b>= N || grid[a][b]=='0' || isVisited[a][b] )
            return;
        isVisited[a][b] = true;
        dfs( grid,isVisited ,a+1,b);
        dfs( grid,isVisited ,a,b-1);
        dfs( grid,isVisited ,a,b+1);
        dfs( grid,isVisited ,a-1,b);
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
