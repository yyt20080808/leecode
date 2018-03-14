package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yyt on 2018/3/10.
 */
//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
//
//        Examples:
//        [2,3,4] , the median is 3
//
//        [2,3], the median is (2 + 3) / 2 = 2.5
//
//        Design a data structure that supports the following two operations:
//
//        void addNum(int num) - Add a integer number from the data stream to the data structure.
//        double findMedian() - Return the median of all elements so far.
//        For example:
//
//        addNum(1)
//        addNum(2)
//        findMedian() -> 1.5
//        addNum(3)
//        findMedian() -> 2
public class MedianFinder {
    private Queue<Integer> small = new PriorityQueue(1, new Comparator<Integer>() {

        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    } );
    private Queue<Integer> large = new PriorityQueue();
    public MedianFinder() {
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }


    public double findMedian() {
        if (large.size()>small.size())
            return large.peek();
        else{
            return (double)(large.peek()+small.peek() )/ 2;
        }
    }

    public static void main(String[] args) {
        int a = 1,b = 2;
        double k = (double)(a+b) / 2;
        System.out.print( k );
    }
}
