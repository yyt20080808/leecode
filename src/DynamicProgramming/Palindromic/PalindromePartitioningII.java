package DynamicProgramming.Palindromic;

/**
 * Created by yyt on 2018/1/15.
 */
// 132 .Given a string s, partition s such that every substring of the partition is a palindrome.
//
//        Return the minimum cuts needed for a palindrome partitioning of s.
//
//        For example, given s = "aab",
//        Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class PalindromePartitioningII {
    public PalindromePartitioningII() {

    }

    // 我觉的还是要用local 和 global 的方法。
    public int minCut(String s) {
        int N = s.length();
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; ++i) {
            dp[i] = N - i - 1;
        }
        boolean[][] judge = getPalindromes( s );

        for(int i = N-1;i>=0;i--){
            for (int j = i; j < N; j++) {
                if(judge[i][j])
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
            }
        }

        return dp[0];
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
        PalindromePartitioningII P2 = new PalindromePartitioningII();
        P2.minCut( "aabbcdedcbbaa" );
    }
}
