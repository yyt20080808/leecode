package StackAndHeap;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by yyt on 2018/2/26.
 */
//Given a string which contains only lowercase letters, remove duplicate letters
// so that every letter appear once and only once. You must make sure your result
// is the smallest in lexicographical order among all possible results.

//Example:
//        Given "bcabc"
//        Return "abc"
//
//        Given "cbacdcbc"
//        Return "acdb"
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> a = new Stack<>();
        int[] k = new int[26];
        for(int i = 0; i < s.length();i++)
            k[s.charAt( i )-'a']++;
        Set<Character> hashSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt( i );
            if (!hashSet.contains(c)) {
                while (!a.isEmpty() && a.peek() > c && k[a.peek()-'a'] > 0) {
                    hashSet.remove(a.peek());
                    a.pop();
                }
                // 判断后面不会再出现比自己还小的数字的时候
                // 比如 bcabc 首先入展的是b c，
                // 当轮到a时，发现后面也会出现bc,并且bc都比a要小很多，所以就直接将bc出栈，将a 放进去。
                a.push(c);
                hashSet.add(c);
            }
            k[c-'a']--;
        }
        StringBuilder res = new StringBuilder(  );
        while(!a.isEmpty())
            res.append( a.pop() );
        res.reverse();
        return res.toString();
}

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println( r.removeDuplicateLetters( "cbacdcbc" ) );
    }
}
