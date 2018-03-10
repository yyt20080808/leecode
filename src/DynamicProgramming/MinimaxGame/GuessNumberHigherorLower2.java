package DynamicProgramming.MinimaxGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yyt on 2018/3/2.
 */
//We are playing the Guess Game. The game is as follows:
//
//        I pick a number from 1 to n. You have to guess which number I picked.
//
//        Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
//
//        However, when you guess a particular number x, and you guess wrong, you pay $x.
// You win the game when you guess the number I picked.
//
//        Example:
//
//        n = 10, I pick 8.
//
//        First round:  You guess 5, I tell you that it's higher. You pay $5.
//        Second round: You guess 7, I tell you that it's higher. You pay $7.
//        Third round:  You guess 9, I tell you that it's lower. You pay $9.
//
//        Game over. 8 is the number I picked.
//
//        You end up paying $5 + $7 + $9 = $21.
//        Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
public class GuessNumberHigherorLower2 {
    public int getMoneyAmount(int n) {
        int[][] t = new int[n+1][n+1];
        return Dp( t,1,n );
    }

    private int Dp(int[][] t, int start, int end) {
        if (start >= end)
            return 0;
        if(t[start][end] != 0) return t[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int temp =i+ Math.max( Dp( t,start,i-1 ),Dp( t,i+1,end ) );
            res = Math.min( temp,res );
        }
        t[start][end] = res;
        return res;
    }

    public static void main(String[] args) {
//        GuessNumberHigherorLower2 g = new GuessNumberHigherorLower2();
//        System.out.println(g.getMoneyAmount( 10 ));
        // 浅拷贝
        int[][] a = new int[2][2];
        a[1][0] = 1;
        a[1][1] = 2;
        int[][]b = new int[2][2];
        b[0] = Arrays.copyOf(a[0],2);
        b[1] = Arrays.copyOf(a[1],2);
        b[1][1] = 5;
        System.out.println( a[1][1] );
        int[] c = new int[2];
        c[1] = 2;
        int[]d = Arrays.copyOf( c,2 );
        d[1] = 5;
        System.out.println( c[1] );
    }
}
