package DynamicProgramming;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/2/8.
 */
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
//
//        Return all such possible sentences.
//
//        For example, given
//        s = "catsanddog",
//        dict = ["cat", "cats", "and", "sand", "dog"].
//
//        A solution is ["cats and dog", "cat sand dog"].
public class WordBreak2 {
    private List<List<String>> res;

    private class TreeNode {
        private TreeNode[] next;
        private boolean isEnd;

        private TreeNode() {
            next = new TreeNode[26];
        }
    }

    private TreeNode buildTree(List<String> wordDict) {
        TreeNode root = new TreeNode();
        for (String s : wordDict) {
            buildNode( s, 0, root );
        }
        return root;
    }

    private void buildNode(String s, int index, TreeNode p) {
//        if(index == s.length())
//            return;
        char t = s.charAt( index );
        if (p.next[t - 'a'] != null) {
            if (index == s.length() - 1)
                p.next[t - 'a'].isEnd = true;
            else
                buildNode( s, index + 1, p.next[t - 'a'] );
        } else {
            p.next[t - 'a'] = new TreeNode();
            ;
            if (index == s.length() - 1)
                p.next[t - 'a'].isEnd = true;
            else
                buildNode( s, index + 1, p.next[t - 'a'] );
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
    public boolean check(String s,TreeNode root) {
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

    public  List<String> wordBreak(String s, List<String> wordDict) {
        TreeNode root = buildTree( wordDict );
        List<String> trueRes = new ArrayList<>(  );
        if (!check(s,root))
            return trueRes;
        res = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<>();
        DFS( s, root, tempList ,0);

        for (List<String> e: res){
            StringBuilder x = new StringBuilder( e.get( 0 ) );
            for (int i = 1; i < e.size(); i++) {
                x.append( " " );
                x.append( e.get( i ) );
            }
            trueRes.add( x.toString() );
        }
        return trueRes;
    }

    private void DFS(String s, TreeNode root, List<String> tempList,int index) {
        if (s.length() == index) {
            res.add( new ArrayList<>( tempList ) );
            return;
        }
        TreeNode temp = root;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt( i );
            if (temp.next[c-'a'] !=null) {
                temp = temp.next[c-'a'];
                if(temp.isEnd){
                    tempList.add( s.substring( index, i+1 ) );
                    DFS(s,root,tempList,i+1);
                    tempList.remove( tempList.size()-1 );
                }
            }
            else
                break;
        }
    }


    public static void main(String[] args) {
        WordBreak2 w = new WordBreak2();
        ArrayList<String> wordDict = new ArrayList<>(  );
        wordDict.add( "cat" );
        wordDict.add( "cats" );
        wordDict.add( "and" );
        wordDict.add( "sand" );
        wordDict.add( "dog" );
        List<String> Myres = w.wordBreak("catsanddog",wordDict  );
        for(String e: Myres)
            System.out.println(e);
        System.out.println(Myres.size() );
    }
}
