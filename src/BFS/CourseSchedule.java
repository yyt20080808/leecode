package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yyt on 2018/1/23.
 */
//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
//        which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs,
//        is it possible for you to finish all courses?
//
//        For example:
//
//        2, [[1,0]]
//        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//        2, [[1,0],[0,1]]
//        There are a total of 2 courses to take. To take course 1 you should have finished course 0,
//        and to take course 0 you should also have finished course 1. So it is impossible.
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] k = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] e : prerequisites) {
            k[e[0]][e[1]] = true;
            inDegree[e[1]]++;
        }
        Queue<Integer> startPoint = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            // 将所有可以作为初始节点的点加入一个队列之中
            if (inDegree[i] == 0)
                startPoint.add( i );
        }
        int count = 0;
        while (!startPoint.isEmpty()) {
            int cur = startPoint.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                // 若果存在这条边 cur 到 那儿的一条边
                if (k[cur][i]) {
                    inDegree[i]--;
                    // 正好满足了所有的需求，然后就可以将其加入下一个队列了
                    if (inDegree[i] == 0)
                        startPoint.add( i );
                }
            }
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        int[][] a = { {1, 0}};
        CourseSchedule s = new CourseSchedule();
        System.out.print( s.canFinish( 2, a ) );
    }
}
