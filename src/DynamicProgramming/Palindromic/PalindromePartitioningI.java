package DynamicProgramming.Palindromic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/15.
 */
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//        Return all possible palindrome partitioning of s.
//
//        For example, given s = "aab",
//        Return[
//  [["aa","b"],
//          ["a","a","b"]
//          ]
public class PalindromePartitioningI {
    public PalindromePartitioningI() {

    }

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if (s.equals( "" ))
            return res;
        boolean[][] judge = getPalindromes( s );
        dfs( s, res, null, judge, 0 );
        return res;
    }

    private void dfs(String s, List<List<String>> res, ArrayList<String> t, boolean[][] judge, int index) {
        if (index == s.length()) {
            res.add( t );
            return;
        }
        if (t == null) {
            t = new ArrayList<String>();
        }

        // 这里从某种地方开始我们的dfs启程
        for (int j = index; j < s.length(); j++) {
            if (judge[index][j]) {
                // clone 是浅层拷贝
                ArrayList<String> temp = (ArrayList<String>) t.clone();
                temp.add( s.substring( index, j + 1 ) );
                dfs( s, res, temp, judge, j + 1 );
            }
        }

    }

    private boolean[][] getPalindromes(String s) {
        int N = s.length();
        boolean[][] judge = new boolean[N][N];
        for (int i = 0; i < N; i++)
            judge[i][i] = true;
        // i 表示开头的那个索引
        for (int i = N - 1; i >= 0; i--) {
            // j 表示后面的索引
            for (int j = i + 1; j < N; j++) {
                if (s.charAt( i ) == s.charAt( j )) {
                    // 很烦的一点，judge 是后来才算出来的
                    if (j >= i + 2 && judge[i + 1][j - 1])
                        judge[i][j] = true;
                        // 相邻的情况，哈哈
                    else if (i + 1 == j)
                        judge[i][j] = true;
                }
            }
        }
        return judge;
    }

    public static void main(String[] args) {
        PalindromePartitioningI P1 = new PalindromePartitioningI();
        P1.partition( "aabbcdedcbbaa" );
    }
}
