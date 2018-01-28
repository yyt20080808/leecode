package StackAndHeap;

import java.util.*;

/**
 * Created by yyt on 2018/1/24.
 */
// leetcode 218 hard
//    Buildings Skyline Contour The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
//
//        For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
//
//        The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
//
//        For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
//
//        Notes:
//
//        The number of buildings in any input list is guaranteed to be in the range [0, 10000]. The input list is already sorted in ascending order by the left x position Li. The output list must be sorted by the x position. There must be no consecutive horizontal lines of equal
//        height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
public class SkyLine {
    public SkyLine() {

    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            // 左边定点存负数
            height.add( new int[]{b[0], -b[2]} );
            // 右边定点存正数
            height.add( new int[]{b[1], b[2]} );
        }
        // 对它排序
        Collections.sort( height, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }});
        // 构建堆，按照纵坐标大小来判断 这是从大到小
        Queue<Integer> pq = new PriorityQueue<>( 11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        } );
        // 地平线值0先加入到优先队列中
        pq.offer( 0);
        // prev 用于记录上次 keypoint的高度
        int prev = 0;
        for(int[] h:height){
            // 将左顶点加入到堆中
            if(h[1] < 0)
                pq.offer( -h[1] );
            else
                // 将右顶点对应的左顶点删掉
                pq.remove(h[1]);
            int cur = pq.peek();
            if(prev != cur){
                // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
                result.add( new int[]{h[0],cur} );
                prev = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
