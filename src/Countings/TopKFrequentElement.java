package Countings;

import java.util.*;

/**
 * Created by yyt on 2018/1/30.
 */
//Given a non-empty array of integers, return the k most frequent elements.
//
//        For example,
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n),
// where n is the array's size.
public class TopKFrequentElement {
    public TopKFrequentElement() {

    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(  );
        for (int n:nums){
            if(map.containsKey( n ))
                map.put( n,map.get( n )+1 );
            else
                map.put( n,1 );
        }
        int size = map.size();
        int [][] x = new int[size][2];
        Set<Map.Entry<Integer, Integer>> set= map.entrySet();
        int i = 0;
        for (Map.Entry<Integer,Integer> t:set) {
            x[i][0] =t.getValue();
            x[i][1] = t.getKey();
            i++;
        }
        Arrays.sort( x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        } );
        List<Integer> res = new ArrayList<>(  );
        for (int j = 0; j <k ; j++)
            res.add( x[j][1] );
        return res;

    }

    public static void main(String[] args) {
        TopKFrequentElement t = new TopKFrequentElement();
        int[] nums = {1,1,1,2,2,3};
        t.topKFrequent( nums,2 );
    }
}
