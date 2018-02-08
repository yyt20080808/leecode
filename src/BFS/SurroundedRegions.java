package BFS;

import java.util.LinkedList;
import java.util.Queue;

//Given a 2D board containing 'X' and 'O' (the letter O), capture
// all regions surrounded by 'X'.
//
//        A region is captured by flipping all 'O's into 'X's in
// that surrounded region.
//
//        For example,
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        After running your function, the board should be:
//
//        X X X X
//        X X X X
//        X X X X
//        X O X X
public class SurroundedRegions {
    private int M;
    private int N;

    public void solve(char[][] board) {
        M = board.length;
        if (M == 0)
            return;
        N = board[0].length;
        if (N == 0)
            return;

        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O')
                bfs(i, 0, board);
            if (board[i][N - 1] == 'O')
                bfs(i, N - 1, board);
        }
        for (int i = 1; i < N-1; i++) {
            if (board[0][i] == 'O')
                bfs(0, i, board);
            if (board[M-1][i] == 'O')
                bfs(M-1, i, board);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j]=='O')
                    board[i][j] = 'E';
                else if (board[i][j]=='E')
                    board[i][j] = 'O';
            }
        }

    }

    private void bfs(int x, int y, char[][] board) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);
        int a, b;
        while (!qx.isEmpty()) {
            a = qx.poll();
            b = qy.poll();
            board[a][b] = 'E';
            if (validate(a+1,b) && board[a+1][b]=='O'){
                qx.add(a+1);
                qy.add(b);
            }
            if (validate(a,b+1) && board[a][b+1]=='O'){
                qx.add(a);
                qy.add(b+1);
            }
            if (validate(a-1,b) && board[a-1][b]=='O'){
                qx.add(a-1);
                qy.add(b);
            }
            if (validate(a,b-1) && board[a][b-1]=='O'){
                qx.add(a);
                qy.add(b-1);
            }
        }
    }

    private boolean validate(int x, int y) {
        return x < M && x > 0 && y < N && y > 0;
    }
}
