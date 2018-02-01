package DynamicProgramming;

import java.util.ArrayList;

/**
 * Created by yyt on 2018/1/4.
 */
public class Knapsack {
    public static int[] solutions(int[] w, int[] v, int cap) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = w.length;
        int n = cap;
        int[][] d = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++)
//            for (int j = 0; j <= n; j++)
//                d[i][j] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++){
                if(w[i-1] > j){
                    d[i][j] = d[i-1][j];
                }
                else{
                    // 第一项是不选这个，第二项是选择这个i-1项。
                    d[i][j] = Math.max(d[i-1][j],d[i-1][j-w[i-1]]+v[i-1]);
                }
            }
        System.out.print( d[m][n] );
        return null;
    }

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int cap = 10;
        solutions( w,v,cap );

    }
}
