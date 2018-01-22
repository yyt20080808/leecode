package Tree;

import java.util.HashMap;

/**
 * Created by yyt on 2018/1/21.
 */
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        For example,
//        Given [100, 4, 200, 1, 3, 2],
//        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//        Your algorithm should run in O(n) complexity.
public class LongestConsecutive {
    public LongestConsecutive() {

    }
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(  );
        int res = 0;
        for (int e:num){
            if(!map.containsKey( e )){
                int left = (map.containsKey( e-1 ) )? map.get( e-1 ): 0;
                int right = (map.containsKey( e+1 ) )? map.get( e+1 ): 0;
                // sum 是这个序列的一个长度
                int sum = left + right + 1;
                map.put( e,sum );
                res = Math.max(sum,res);
                // 将这个序列开头也变成这个sum
                map.put( e-left,sum );
                // 将这个序列的结尾变成这个sum
                map.put( e+right,sum );
            }
        }
        return res;
    }

        public static void main(String[] args) {

    }
}
