package Greedy;

import java.util.Arrays;

/**
 * Created by yyt on 2018/2/2.
 */
//Given a char array representing tasks CPU need to do.
// It contains capital letters A to Z where different
// letters represent different tasks.Tasks could be done without original order.
// Each task could be done in one interval. For each interval,
// CPU could finish one task or just be idle.
//
//        However, there is a non-negative cooling interval n that
// means between two same tasks, there must be at least n intervals
// that CPU are doing different tasks or just be idle.
//
//        You need to return the least number of intervals the CPU will
// take to finish all the given tasks.
//
//        Example 1:
//        Input: tasks = ["A","A","A","B","B","B"], n = 2
//        Output: 8
//        Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//        Note:
//        The number of tasks is in the range [1, 10000].
//        The integer n is in the range [0, 100].
public class TaskScheduler {
    public int leastInterval(char[] tasks,int n){
        int[] hash = new int[26];
        for(char c: tasks)
            hash[c-'A']++;
        if(n==0)
            return tasks.length;

        // 拍个序列
        Arrays.sort(hash);
        int min = (hash[25]-1)*(n+1)+1;
        int count = 0;
        for(int j = 24;j >=0;j--){
            if(hash[25]!=hash[j])
                break;
            count++;
        }
        min+= count;
        return Math.max(tasks.length,min);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','B','A','B','A','B'};
        TaskScheduler t = new TaskScheduler();
        System.out.println( t.leastInterval( tasks,1 ));
    }
}
