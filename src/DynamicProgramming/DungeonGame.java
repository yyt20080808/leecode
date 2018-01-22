package DynamicProgramming;

/**
 * Created by yyt on 2018/1/11.
 */
public class DungeonGame {
    public DungeonGame() {

    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int M = dungeon.length;
        int N = dungeon[0].length;

        int[][] health = new int[M][N];
        // 最后位置所需的血量，意思就是前往这个位置所需的最小血量
        health[M - 1][N - 1] = Math.max( 1 - dungeon[M - 1][N - 1], 1 );
        for (int i = M - 2; i >= 0; i--) {
            health[i][N - 1] = Math.max( health[i + 1][N - 1] - dungeon[i][N - 1], 1 );
        }
        for (int i = N - 2; i >= 0; i--) {
            health[M - 1][i] = Math.max( health[M - 1][i + 1] - dungeon[M - 1][i], 1 );
        }
        for (int i = M - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                int down = Math.max( health[i+1][j] - dungeon[i][j],1 );
                int right = Math.max(health[i][j+1]-dungeon[i][j],1);
                health[i][j] = Math.min(down,right);
            }
        }
        return health[0][0];
    }

    public static void main(String[] args) {
        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.print( calculateMinimumHP(a));
    }
}
