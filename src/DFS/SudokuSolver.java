package DFS;

/**
 * Created by yyt on 2018/1/20.
 */
public class SudokuSolver {
    public SudokuSolver() {

    }

    public void solveSudoku(char[][] board) {
        int N = board.length;
        // 行
        boolean[][] used1 = new boolean[N][N];
        // 列
        boolean[][] used2 = new boolean[N][N];
        // 小方格是哪个
        boolean[][] used3 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 首先确定是在第几个小方格。
                int k = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    int nums = board[i][j] - '1';
                    used1[i][nums] = true;
                    used2[j][nums] = true;
                    used3[k][nums] = true;
                }
            }
        }

        boolean res = DFS( board, 0, 0, used1, used2, used3 );
    }

    private boolean DFS(char[][] board, int x, int y, boolean[][] used1, boolean[][] used2, boolean[][] used3) {
        int N = board.length;
        int grid = x / 3 * 3 + y / 3;
        if (board[x][y] == '.') {
            for (int k = 0; k < N; k++) {
                board[x][y] = (char) ('1' + k);
                if (isValidBoard( board, used1, used2, used3, x, y, k )) {
                    // 要验证下个点的时候，要将x y 的点验证一下
                    if (x == 8 && y == 8)
                        // 这是最后一个点，如果成功了，说明这个就是解了
                        return true;
                    else if (x == 8) {
                        // 如果成功了，
                        if (DFS( board, 0, y + 1, used1, used2, used3 ))
                            return true;
                    } else {
                        if (DFS( board, x + 1, y, used1, used2, used3 ))
                            return true;
                    }
                    used1[x][k] = false;
                    used2[y][k] = false;
                    used3[grid][k] = false;
                }
            }
            board[x][y] = '.';
        } else {
            if (x == 8 && y == 8)
                // 这是最后一个点，如果成功了，说明这个就是解了
                return true;
            else if (x == 8) {
                // 如果成功了，
                if (DFS( board, 0, y + 1, used1, used2, used3 ))
                    return true;
            } else {
                if (DFS( board, x + 1, y, used1, used2, used3 ))
                    return true;
            }
        }
        return false;
    }

    private boolean isValidBoard(char[][] board, boolean[][] used1, boolean[][] used2, boolean[][] used3, int x, int y, int val) {
        int grid = x / 3 * 3 + y / 3;
        if (used1[x][val] || used2[y][val] || used3[grid][val])
            return false;
        used1[x][val] = true;
        used2[y][val] = true;
        used3[grid][val] = true;
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        s.solveSudoku( board );
    }
}
