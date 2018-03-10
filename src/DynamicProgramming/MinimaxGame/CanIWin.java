package DynamicProgramming.MinimaxGame;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yyt on 2018/3/2.
 */
//In the "100 game," two players take turns adding, to a running total, any integer from 1
// ..10. The player who first causes the running total to reach or exceed 100 wins.
//
//        What if we change the game so that players cannot re-use integers?
//
//        For example, two players might take turns drawing from a common pool of numbers
// of 1..15 without replacement until they reach a total >= 100.
//
//        Given an integer maxChoosableInteger and another integer desiredTotal, determine
// if the first player to move can force a win, assuming both players play optimally.
//
//        You can always assume that maxChoosableInteger will not be larger than 20 and
// desiredTotal will not be larger than 300.
//
//        Example
//
//        Input:
//        maxChoosableInteger = 10
//        desiredTotal = 11
//
//        Output:
//        false
//
//        Explanation:
//        No matter which integer the first player choose, the first player will lose.
//        The first player can choose an integer from 1 up to 10.
//        If the first player choose 1, the second player can only choose integers from 2 up to 10.
//        The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
//        Same with other integers chosen by the first player, the second player will always win.
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal)
            return true;
        int maxV = maxChoosableInteger * (maxChoosableInteger+1) /2 ;
        if(maxV < desiredTotal)
            return false;
        HashMap<Integer, Boolean> map = new HashMap<>();
        return helper( maxChoosableInteger, desiredTotal, 0, map );
    }

    private boolean helper(int n, int desiredTotal, int state, HashMap<Integer, Boolean> map) {
        if (map.containsKey( state ))
            return map.get( state );
        for (int i = 0; i < n; i++) {
            // 说明 i 还没有被选择上
            if ((state & (1 << i)) == 0){
                if (i + 1 >= desiredTotal || !helper( n, desiredTotal - i - 1, state | (1 << i), map )) {
                    map.getOrDefault( state,true );
                    return true;
                }
            }
        }
        map.put( state,false );
        return false;
    }

    public static void main(String[] args) {
        boolean[] x = new boolean[5];
        System.out.println( Arrays.toString( x ) );
        x[2] = true;
        System.out.println( Arrays.toString( x ) );
    }
}
