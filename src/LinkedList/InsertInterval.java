package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yyt on 2018/1/18.
 */
//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
//
//        Example 1:
//        Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//        Example 2:
//        Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//        This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
public class InsertInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public InsertInterval() {

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> res = new LinkedList<Interval>();
        int N = intervals.size();
        int i = 0;
        // 分成三种情况
        while (i < N && intervals.get( i ).end < newInterval.start)
            res.add( intervals.get( i++ ) );
        // 第二种情况比较要用到max 和 min
        while (i < N && intervals.get( i ).start <= newInterval.end) {
            newInterval.start = Math.min( intervals.get( i ).start, newInterval.start );
            newInterval.end = Math.max( intervals.get( i ).end, newInterval.end );

            i++;
        }
        res.add( newInterval );
        while (i < N)
            res.add( intervals.get( i++ ) );
        return res;
    }

    public static void main(String[] args) {

    }
}
