package DFS;

/**
 * Created by yyt on 2018/1/18.
 */
//Given board =
//
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//        word = "ABCCED", -> returns true,
//        word = "SEE", -> returns true,
//        word = "ABCB", -> returns false.
public class WordSearch {
    public WordSearch() {

    }

    public boolean exist(char[][] board, String word) {
        if(board==null || word==null)
            return false;
        int M = board.length;
        if (M == 0)
            return false;
        int N = board[0].length;
        if (word.length() == 0)
            return false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs( i, j, board, 0, word ))
                    return true;
            }
        }
        return false;

    }

    private boolean dfs(int x, int y, char[][] board, int index, String word) {
        if (word.length() == index)
            return true;
        int M = board.length;
        int N = board[0].length;

        if (y < 0 || x < 0 || x >= M || y >= N)
            return false;
        if (board[x][y] != word.charAt( index ))
            return false;
        char c = word.charAt( index );
        board[x][y] = '*';
        boolean cur = (dfs( x + 1, y, board, index + 1, word ) ||
                dfs( x, y + 1, board, index + 1, word ) ||
                dfs( x, y - 1, board, index + 1, word ) ||
                dfs( x - 1, y, board, index + 1, word ));
        board[x][y] = c;
        return cur;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] s = {"ABCCED","SEE","ABCB"};
//        String[] s = {"ABCESEEEFS"};
        for (String e : s)
            System.out.println( wordSearch.exist( board, e ) );

        int [] a = {2,2,2};
        int[] b = a.clone();
        b[1] = 1;
        b[1] = 3;
        a[0] = 5;
        System.out.print( b[0] );
    }

}
