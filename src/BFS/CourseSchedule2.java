package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yyt on 2018/2/8.
 */

//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//        Some courses may have prerequisites, for example to take course 0
// you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs,
// return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of
// them. If it is impossible to finish all courses, return an empty array.
//
//        For example:
//
//        2, [[1,0]]
//        There are a total of 2 courses to take. To take course 1 you should have
// finished course 0. So the correct course order is [0,1]
//
//        4, [[1,0],[2,0],[3,1],[3,2]]
//        There are a total of 4 courses to take. To take course 3 you should
// have finished both courses 1 and 2. Both courses 1 and 2 should be taken after
// you finished course 0. So one correct course order is [0,1,2,3]. Another correct
// ordering is[0,2,1,3].
//
//        Note:
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inCounts = new int[numCourses];
        boolean[][] t = new boolean[numCourses][numCourses];
        for (int[] e : prerequisites) {
            if (!t[e[0]][e[1]]) {
                t[e[0]][e[1]] = true;
                inCounts[e[1]]++;
            }
        }
        int[] res = new int[numCourses];
        Queue<Integer> start = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inCounts[i] == 0)
                start.offer( i );
        int left = numCourses-1;
        while (start.size() > 0) {
            int now = start.poll();
            res[left--] = now;
            for (int i = 0; i < numCourses; i++) {
                if (t[now][i]) {
                    inCounts[i]--;
                    if (inCounts[i] == 0)
                        start.offer( i );
                }
            }
        }
        if (left != -1)
            return new int[0];
        else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] p = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        CourseSchedule2 c = new CourseSchedule2();
        c.findOrder( 10, p );
    }
}
