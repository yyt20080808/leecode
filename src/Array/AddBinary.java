package Array;

/**
 * Created by yyt on 2018/2/6.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int M = a.length();
        int N = b.length();
        if (M == 0)
            return b;
        if (N == 0)
            return a;
        // 然后再将他们扩展一下，是他们的位数相同
        int l = M;
        if (M < N) {
            l = N;
            a = addString( a, N - M );
        } else if (M > N) {
            l = M;
            b = addString( b, M - N );
        }
        char[] res = new char[l + 1];
        int flag = 0;
        for (int i = 0; i < l; i++) {
            int temp = flag +
                    (a.charAt( l - i - 1 ) - '0') +
                    (b.charAt( l - i - 1 ) - '0');
            if (temp == 3) {
                flag = 1;
                res[l - i] = '1';
            } else if (temp == 2) {
                flag = 1;
                res[l - i] = '0';
            } else if (temp == 1) {
                res[l - i] = '1';
                flag = 0;
            }
            else
                res[l-i] = '0';
        }
        StringBuilder s = new StringBuilder();
        if (flag == 1) {
            res[0] = '1';
            for (char e : res)
                s.append( e );
        } else {
            for (int i = 1; i <= l; i++)
                s.append( res[i] );
        }
        return s.toString();
    }

    private String addString(String a, int num) {
        if (num > 0) {
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < num; i++)
                t.append( '0' );
            return t.toString() + a;
        }
        return a;
    }


    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println( a.addBinary( "1010", "1011" ) );
    }
}
