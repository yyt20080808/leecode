package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yyt on 2018/1/18.
 */
public class WordSearch2 {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    // 先构造出一颗前缀树来。
    private TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            TrieNode p = root;
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt( j ) - 'a';
                if (p.next[index] == null)
                    p.next[index] = new TrieNode();
                p = p.next[index];
            }
            p.word = words[i];
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null)
            return null;
        TrieNode root = buildTrieTree( words );
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs( i, j, board,root,res);
            }
        }
        return res;
    }


    private void dfs(int x, int y, char[][] board, TrieNode p, List<String> res) {
        int M = board.length;
        int N = board[0].length;
        if (y < 0 || x < 0 || x >= M || y >= N)
            return;
        char c = board[x][y];
        if (c == '*' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add( p.word );
            p.word = null;// de-duplicate
        }
        board[x][y] = '*';
        dfs( x + 1, y, board, p, res );
        dfs( x, y + 1, board, p, res );
        dfs( x, y - 1, board, p, res );
        dfs( x - 1, y, board, p, res );
        board[x][y] = c;

    }

    public static void main(String[] args) {
        WordSearch2 w = new WordSearch2();
        String[] s = {"a", "bbbb"};
        w.buildTrieTree( s );
    }
}
