package DFS;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.scene.control.Alert;

import javax.xml.parsers.FactoryConfigurationError;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by yyt on 2018/9/14.
 */
//Additive number is a string whose digits can form additive sequence.
//
//        A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
//        Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
//
//        Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
//        Example 1:
//
//        Input: "112358"
//        Output: true
//        Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//        1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//        Example 2:
//
//        Input: "199100199"
//        Output: true
//        Explanation: The additive sequence is: 1, 99, 100, 199.
//        1 + 99 = 100, 99 + 100 = 199
public class AdditiveNumber {
    public boolean isAdditiveNumber(String s) {
        int n = s.length();
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                long a = parse(s.substring(0, i));
                long b = parse(s.substring(i, j));
                if (a == -1 || b == -1) continue;
                if (dfs(s.substring(j), a, b))   return true;
            }
        }
        return false;
    }

    boolean dfs(String s, long a, long b) {
        if (s.length() == 0)    return true;

        for (int i=1; i<=s.length(); i++) {
            long c = parse(s.substring(0, i));
            if (c == -1)    continue;
            if (c-a == b && dfs(s.substring(i), b, c)) {
                return true;
            }
        }
        return false;
    }

    long parse(String s) {
        if (!s.equals("0") && s.startsWith("0"))    return -1;
        long result = 0;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
    }
//    private int [] nums;
//    public boolean isAdditiveNumber(String num) {
//        char[] s = num.toCharArray();
//        nums = new int[s.length];
//        for (int i = 0; i < s.length;i++)
//            nums[i] = s[i]-'0';
//        for (int i = 0; i <s.length/2;i++){
//            boolean t = backtrace( num,i+1,num.substring( 0,i+1 ),null );
//            if(t)
//                return true;
//        }
//
//        return false;
//    }
//    private boolean backtrace(String num, int start,String lastString, String nextString){
//        if (start==num.length()-1)
//            return true;
//        if(nextString != null){
//            String b = ifAddble( lastString,nextString,start );
//            if(start+b.length() <= num.length() && num.substring( start,start+b.length() ).equals( b ))
//                return backtrace( num,start+b.length(),nextString, b);
//        }
//
//        int length = Math.max(  lastString.length(),(num.length()-start) / 2 );
//        for (int i = start+1; i <= start+length; i++) {
//            String here = num.substring( start,i );
//            String temp = ifAddble(lastString,here,i);
//            int tempLength = temp.length();
//            if(i+tempLength <= num.length() && num.substring( i,i+tempLength ).equals( temp )){
//                boolean t = backtrace( num,i+tempLength,here,temp);
//                if (t)
//                    return true;
//            }
//        }
//        return false;
//    }
//    private String ifAddble(String a,String b,int start){
//        int A_len = a.length();
//        int B_len = b.length();
//        int i = 1,j = 1;
//        int count=0;
//        StringBuilder res = new StringBuilder(  );
//        while(i <= A_len || j <= B_len || count > 0){
//            int A = count;
//            if(i <=A_len) {
//                A += nums[start - B_len - i];
//                i++;
//            }if(j <= B_len){
//                A += nums[start-j];
//                j++;
//            }
//            if(A >= 10){
//                count = 1;
//                A = A%10;
//                res.append( A );
//            }
//            else{
//                count = 0;
//                res.append( A );
//            }
//        }
//        return res.reverse().toString();
//
//    }

    public static void main(String[] args) {
        String b = "199100199";
//        String b = "1123";
        AdditiveNumber a = new AdditiveNumber();

        boolean c = a.isAdditiveNumber( b );
        System.out.println(c);
    }
}
