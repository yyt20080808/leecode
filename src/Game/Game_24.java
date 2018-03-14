package Game;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yyt on 2018/3/12.
 */
public class Game_24 {
    // 也就是24点游戏
    private ArrayList<Set<Double>> s;
    private static int t = 0, p = 0;
    private double target = 24;
    private double error = 10e-6;

    public boolean judgePoint24(int[] nums) {
        int N = nums.length;
        s = new ArrayList<>();
        for (int i = 0; i <= Math.pow( 2, N ) - 1; i++)
            s.add( new HashSet<>() );

        for (int i = 0; i < N; i++)
            s.get( (int) Math.pow( 2, i ) ).add( (double) nums[i] );

        for (int i = 1; i <= Math.pow( 2, N ) - 1; i++) {
            f( i );
        }
        for (double e : s.get( (int) Math.pow( 2, N ) - 1 )) {
            if ((e - target < error) && (target - e < error))
                return true;
        }

        return false;
    }

    private Set<Double> f(int i) {
        if (!s.get( i ).isEmpty()) {
            p++;
            return s.get( i );
        }
        for (int x = 1; x < i; x++) {
            if ((x & i) == x) {
                Set<Double> t = fork( f( x ), f( i - x ) );
                for (double e : t)
                    s.get( i ).add( e );
            }
        }
        return s.get( i );
    }

    private Set<Double> fork(Set<Double> a, Set<Double> b) {
        t++;
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;
        Set<Double> res = new HashSet<>();
        for (Double i : a)
            for (Double j : b) {
                res.add( i + j );
                res.add( i - j );
                res.add( j - i );
                res.add( i * j );
                if (i != 0)
                    res.add( j / i );
                if (j != 0)
                    res.add( i / j );
            }
        return res;
    }

    public static void main(String[] args) {
        Game_24 g = new Game_24();
        int[] nums = {1,2,1,2};
        System.out.println( g.judgePoint24( nums ) );
        System.out.println( t + "\t" + Integer.toString( p ) );
    }
}
