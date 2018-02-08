package DynamicProgramming;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yyt on 2018/1/21.
 */
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// determine if s can be segmented into a space-separated sequence of one or more dictionary
// words. You may assume the dictionary does not contain duplicate words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".
public class WordBreak {
    private class TreeNode{
        private TreeNode[] next;
        private boolean isEnd;
        private TreeNode(){
            next = new TreeNode[26];
        }
    }

    private TreeNode buildTree(List<String> wordDict){
        TreeNode root = new TreeNode();
        for (String s:wordDict){
             buildNode(s,0,root);
        }
        return root;
    }
    private void buildNode(String s,int index,TreeNode p){
//        if(index == s.length())
//            return;
        char t = s.charAt( index );
        if(p.next[t-'a'] != null){
            if (index == s.length()-1)
                p.next[t-'a'].isEnd = true;
            else
                buildNode( s,index+1,p.next[t-'a'] );
        }
        else{
            p.next[t-'a'] = new TreeNode();;
            if (index == s.length()-1)
                p.next[t-'a'].isEnd = true;
            else
                buildNode( s,index+1,p.next[t-'a'] );
        }
    }

    private boolean contains(String s, TreeNode root){
        TreeNode temp = root;
        int N = s.length();
        int i = 0;
        while(i < N){
            if(temp.next[s.charAt( i )-'a'] == null)
                return false;
            temp = temp.next[s.charAt( i )-'a'];
            i++;
        }
        return temp.isEnd;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TreeNode root = buildTree( wordDict );
        int N =s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i] = dp[j] && contains( s.substring( j,i ),root );
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
        System.out.println(w.wordBreak( s, wordDict ));

    }
}
