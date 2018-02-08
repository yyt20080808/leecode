package HashTable;

import java.util.HashMap;

/**
 * Created by yyt on 2018/2/2.
 */
//Given an array of integers and an integer k,
// you need to find the total number of continuous subarrays whose sum equals to k.
//
//        Example 1:
//        Input:nums = [1,1,1], k = 2
//        Output: 2
//        Note:
//        The length of the array is in range [1, 20,000].
//        The range of numbers in the array is [-1000, 1000] and
// the range of the integer k is [-1e7, 1e7].
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums,int target){
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>(  );
        map.put( 0,1 );
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            // 说明曾经已经有字串到达过这个 sum-target 的值了
            //sum-target 这个差值的key 存在，目前是sum -> AB
            //   AB  sum = sum(AB) sum-target = sum(A) 那么就说明 target = sum(B)了
            //
            if(map.containsKey( sum-target ))
                res += map.get( sum-target );
            // 这个才是说明，以前能够到达sum 这个值的次数
            map.put( sum,map.getOrDefault( sum,0 )+1 );
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2,3};
        SubarraySumEqualsK f = new SubarraySumEqualsK();
        f.subarraySum( nums,6 );
    }
}
