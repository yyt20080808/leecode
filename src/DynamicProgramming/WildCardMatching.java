package DynamicProgramming;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Created by yyt on 2018/1/2.
 */
public class WildCardMatching {
    public WildCardMatching() {

    }
    public static boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int lens = s.length();
        int lenp = p.length();

        // 创建一个Dp二维数组
        boolean[][] D = new boolean[lens + 1][lenp + 1];

        boolean flag = false;

        for (int i = 0; i <= lens; i++) {
            flag = false;
            for (int j = 0; j <= lenp; j++) {
                // both is empty.
                if (i == 0 && j == 0) {
                    D[i][j] = true;
                    flag = true;
                    continue;
                }

                // if PalindromeLinkedList is empty, s is not empty, it is false.
                if (j == 0) {
                    D[i][j] = false;
                    continue;
                }

                // if S is empty, PalindromeLinkedList is not empty
                if (i == 0) {
                    D[i][j] = D[i][j - 1] && p.charAt(j - 1) == '*';
                } else {
                    D[i][j] = (matchChar(s.charAt(i - 1), p.charAt(j - 1)) && D[i - 1][j - 1])
                            || (p.charAt(j - 1) == '*' && (D[i][j - 1] || D[i - 1][j]));
                }

                if (D[i][j]) {
                    flag = true;
                }

                // Greedy. 在此即可以退出，因为* 可以匹配余下的所有的字符串。
                if (D[i][j] && p.charAt(j - 1) == '*' && j == lenp) {
                    return true;
                }
            }

            if (!flag) {
                return false;
            }
        }

        return D[lens][lenp];
    }

    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }


    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        return dp[m][n];


    }

    public static void main(String[] args) {
        System.out.println(isMatch("3",""));
    }

}
