package Game;

import java.util.*;

/**
 * Created by yyt on 2018/3/14.
 */
//Given two words (beginWord and endWord), and a dictionary's word list, find the length
// of shortest transformation sequence from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time.
//        Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word.
//        For example,
//
//        Given:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log","cog"]
//        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//    Note:
//            Return 0 if there is no such transformation sequence.
//            All words have the same length.
//            All words contain only lowercase alphabetic characters.
//            You may assume no duplicates in the word list.
//            You may assume beginWord and endWord are non-empty and are not the same.
public class WordLadder {
    // 属于BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Boolean> map = new HashMap<>(  );
        for (String e:wordList)
            map.put( e,true );
        if(!map.containsKey( endWord ))
            return 0;
        else if(endWord.equals( beginWord ))
            return 1;
        Queue<String> q = new LinkedList<>(  );
        int level = 1;
        int size = 1;
        q.add( beginWord );
        map.put( beginWord,false );
        int N = beginWord.length();
        while(!q.isEmpty()){
            String now = q.poll();
            size--;
            char[] temp = now.toCharArray();
            for (int i = 0; i < N; i++) {
                char c = temp[i];
                for (char x = 'a';x <='z';x++){
                     if(x != c){
                         temp[i] = x;
                         String judge = String.valueOf( temp );
                         // 成功的标记
                         if(judge.equals(   endWord))
                             return level+1;
                         // 找到了下一个需要入栈的String
                         if(map.containsKey( judge ) && map.get( judge )){
                             q.offer( judge );
                             map.put( judge,false );
                         }
                     }
                }
                temp[i] = c;
            }
            // 相当于更新队列的操作
            if(size==0){
                level++;
                size = q.size();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] k = {"hot","dot","dog","lot","log","cog"};
        List<String> dict = new ArrayList<>( );
        for(String e:k)
            dict.add( e );
        WordLadder w = new WordLadder();
        assert w.ladderLength( "hit","cog",dict ) == 5;
    }
}
