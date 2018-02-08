package StackAndHeap;

import java.util.Stack;

/**
 * Created by yyt on 2018/1/30.
 */
//s = "3[a]2[bc]", return "aaabcbc".
//        s = "3[a2[c]]", return "accaccacc".
//        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
public class DecodeString {
    public DecodeString() {

    }

    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            // 如果是数字
            if (isdigit( s.charAt( idx ) )) {
                int count = s.charAt( idx ) - '0';
                idx++;
                while (isdigit( s.charAt( idx ) )) {
                    count = count * 10 + (s.charAt( idx ) - '0');
                    idx++;
                }
                countStack.push( count );
            }
            // 如果是重复序列的开始
            else if (s.charAt( idx ) == '[') {
                resStack.push( res );
                res = "";
                idx++;
            } else if (s.charAt( idx ) == ']') {
                StringBuilder temp = new StringBuilder( resStack.pop() );
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append( res );
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt( idx++ );
            }
        }
        return res;
    }

    private boolean isdigit(char c) {
        return c <= '9' && c >= '0';
    }


    public static void main(String[] args) {

    }
}
