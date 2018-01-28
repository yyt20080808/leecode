package StackAndHeap;

import LinkedList.InsertInterval;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by yyt on 2018/1/26.
 */
//Given an array nums, there is a sliding window of size k which is moving
// from the very left of the array to the very right.
// You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.
//
//        For example,
//        Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//        Therefore, return the max sliding window as [3,3,5,5,6,7].
//
//        Note:
//        You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
public class SlidingWindowMaxium {
    public SlidingWindowMaxium() {

    }
    public  int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if(N==0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>(  );

        int[]res = new int[N-k+1];
        int count =0;
        for (int i = 0;i<N;i++){
            if(!deque.isEmpty() && deque.peek() < i - k+1)
                deque.poll();
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offer( i );
            if(i >= k-1){
                res[count++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,-3,4,-2,-1,-4,-6,4,2};
        new SlidingWindowMaxium().maxSlidingWindow(nums,3);
    }
}
