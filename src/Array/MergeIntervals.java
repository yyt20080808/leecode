package Array;

import LinkedList.InsertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yyt on 2018/2/5.
 */
//Given a collection of intervals, merge all overlapping intervals.
//
//        For example,
//        Given [1,3],[2,6],[8,10],[15,18],
//        return [1,6],[8,10],[15,18].
public class MergeIntervals {
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

    public MergeIntervals() {

    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort( intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        } );
        List<Interval> res = new ArrayList<>(  );
        if (intervals.size() == 0)
            return res;
        Interval start = intervals.get( 0 );

        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get( i );
            if (start.end >= temp.start) {
                start.end = Math.max( start.end, temp.end );

            }
            else{
                res.add( start);
                start = temp;
            }
        }
        res.add( start );
        return res;
    }



    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();

    }
}
