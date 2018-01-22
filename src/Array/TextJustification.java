package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/18.
 */
//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//        You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//        For the last line of text, it should be left justified and no extra space is inserted between words.
//
//        For example,
//        words: ["This", "is", "an", "example", "of", "text", "justification."]
//        L: 16.
//
//        Return the formatted lines as:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//        Note: Each word is guaranteed not to exceed L in length.
public class TextJustification {
    public TextJustification() {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int N = words.length;
        ArrayList<String> res = new ArrayList<String>();
        // count 用来测量有几个单词
        int count = 0;
        int now = 0;
        if(N==1 && words[0].equals( "" )){
            StringBuilder temp = new StringBuilder(  );
            for (int i = 0; i < maxWidth; i++) {
                temp.append( ' ' );
            }
            res.add( temp.toString() );
            return res;
        }
        for (int i = 0; i < N; ) {
            if (words[i].equals("")){
                i++;
                continue;
            }
            if (now == 0) {
                now += words[i].length();
                count++;
                i++;
            } else if (now + words[i].length() + 1 <= maxWidth) {
                now += (words[i].length() + 1);
                count++;
                i++;
            }
            if (i == N || now + words[i].length() + 1 > maxWidth) {
                StringBuilder temp = new StringBuilder();
                if (count == 1) {
                    temp.append( words[i - 1] );
                    for (int j = 0; j < maxWidth - now; j++)
                        temp.append( " " );
                } else {
                    int width = (maxWidth - now) / (count - 1);
                    int el = (maxWidth - now) % (count - 1);
                    for (int j = 1; j < count; j++) {
                        temp.append( words[i - count + j - 1] );
                        for (int k = 0; k <= width; k++) {
                            temp.append( ' ' );
                        }
                        if (el-- > 0)
                            temp.append( ' ' );
                    }
                    temp.append( words[i - 1] );
                }
                count = 0;
                now = 0;
                res.add( temp.toString() );
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
//        String[] e = {"This", "is", "an", "example", "sof", "text", "justification."};
        String[] e = {"a"};
        t.fullJustify( e, 1 );
    }
}
