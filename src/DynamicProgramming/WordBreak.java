package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yyt on 2018/1/21.
 */
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".
public class WordBreak {
    public WordBreak() {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String e : wordDict)
            set.add( e );
        int N =s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i] = dp[j] && set.contains( s.substring( j,i ) );
                if(dp[i])
                    break;
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add( "leet" );
        wordDict.add( "code" );
        WordBreak w = new WordBreak();
        w.wordBreak( s, wordDict );

    }
}
