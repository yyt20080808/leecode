package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yyt on 2018/1/29.
 */
//Suppose you have a random list of people standing in a queue.
//        Each person is described by a pair of integers (h, k),
//        where h is the height of the person and k is the number of people in front of
//        this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//
//        Note:
//        The number of people is less than 1,100.
//
//
//        Example
//
//        Input:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//        Output:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
public class QueueReconstructionbyHeight {
    public QueueReconstructionbyHeight() {

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort( people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        } );
        List<int[]> list = new ArrayList<>( );
        for (int[] v: people){
            list.add( v[1],v );
        }
        return list.toArray(new int[people.length][]);

    }

    public static void main(String[] args) {

    }
}
