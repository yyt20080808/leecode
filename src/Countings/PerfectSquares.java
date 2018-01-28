package Countings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by yyt on 2018/1/27.
 */
//Given a positive integer n, find the least number of perfect square numbers
//        (for example, 1, 4, 9, 16, ...) which sum to n.
//
//        For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
//given n = 13, return 2 because 13 = 4 + 9.
public class PerfectSquares {
    public PerfectSquares() {

    }

    // 直接使用BFS算法吧
    public int numSquares(int n) {
        if(n <1)
            return 0;
        int depth = 1;
        // 这个set 用来记录重复值的。
        Set<Integer> set = new HashSet<>();
        // 记录每一层的结果的
        Queue<Integer> queue = new LinkedList<>(  );
        for (int i = 1; i*i <=n ; i++) {
            int m = i*i;
            if (m == n)
                return depth;
            queue.offer( m );
            set.add( m );
        }
        depth++;
        while(!queue.isEmpty()){
            // 记录队列的最后一个值,作为下一层开始的标志。
            int size = queue.size();
            while(size-- > 0){
                int m = queue.poll();
                for (int i = 1; i*i <= n-m; i++) {
                    int temp = i*i + m;
                    // 发现找到了这个数字的组合了
                    if(temp == n)
                        return depth;
                    if(!set.contains( temp )){
                        // 如果原来的set中不含这个temp ，它可以作为下一层的起始点
                        queue.add( temp );
                        set.add( temp );
                    }
                }
            }
            depth++;

        }
        return depth;
    }

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        p.numSquares( 8 );
    }
}
