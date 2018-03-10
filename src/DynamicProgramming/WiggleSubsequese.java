package DynamicProgramming;

import Array.WiggleSort;

/**
 * Created by yyt on 2018/3/10.
 */
//A sequence of numbers is called a wiggle sequence if the differences between successive
// numbers strictly alternate between positive and negative. The first difference (if one exists)
// may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
//
//        For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are
// alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
// the first because its first two differences are positive and the second because its last difference is zero.
//
//        Given a sequence of integers, return the length of the longest subsequence that is a wiggle
// sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from
// the original sequence, leaving the remaining elements in their original order.
//
//        Examples:
//        Input: [1,7,4,9,2,5]
//        Output: 6
//        The entire sequence is a wiggle sequence.
//
//        Input: [1,17,5,10,13,15,10,5,16,8]
//        Output: 7
//        There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
//
//        Input: [1,2,3,4,5,6,7,8,9]
//        Output: 2
public class WiggleSubsequese {
    public int wiggleMaxLength(int[] nums) {
        int N = nums.length;
        if (N <= 1)
            return N;
        int k = 0;
        // 排除开头的时候全部相等的情况
        while (k < N - 1 && nums[k] == nums[k + 1]) {
            k++;
        }
        if (k == N - 1)
            return 1;

        boolean isSmall = nums[k+1] < nums[0];
        int key = nums[k+1];
        int res = 2;
        for (int i = k+2; i < N; i++) {
            // 如果 key 比较小的话，拿下一个就是找大数字
           if(nums[i] < key){
               // 这儿不添加新的res，而是更新key
               if(isSmall)
                   key = nums[i];
               // 结果加1，isSmall 反转
               else{
                   key = nums[i];
                   res++;
                   isSmall = !isSmall;
               }
           }else if(nums[i] > key){
               if(!isSmall){
                   key = nums[i];
               }
               else{
                   key = nums[i];
                   res++;
                   isSmall = !isSmall;
               }
           }
           // 如果相等了，什么也别管
            else{
           }
        }
        return res;
    }

    public static void main(String[] args) {
        WiggleSubsequese w = new WiggleSubsequese();
        int [] nums = {3,3,3,2,5};
        assert w.wiggleMaxLength( nums) == 3;
        int[] nums2 = {1,4,2,9,3,7,5,8,1};
        assert w.wiggleMaxLength( nums2) == 9;
        int[] nums3 = {1,4,2,10,9,3,7,5,8};
        assert w.wiggleMaxLength( nums3) == 8;
        assert w.wiggleMaxLength( nums3 )==7;
    }
}
