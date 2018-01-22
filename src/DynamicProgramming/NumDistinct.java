package DynamicProgramming;

/**
 * Created by yyt on 2018/1/7.
 */
public class NumDistinct {
    public NumDistinct() {

    }

    public static int solutions(String s, String t) {
        int M = s.length();
        int N = t.length();

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) dp[i][0] = 1;

        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N && j <= i; ++j) {
                if (i == j){
                    if (s.substring( 0,i ).equals(  t.substring( 0,i )))
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 0;
                }
                else if (s.charAt( i - 1 ) == t.charAt( j - 1 )) {
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - 1];
                } else
                    dp[i][j] = dp[i-1][j ];
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        System.out.print( solutions( "ABBD", "AB" ) );
    }
}
