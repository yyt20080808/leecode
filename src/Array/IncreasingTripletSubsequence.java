package Array;

/**
 * Created by yyt on 2018/3/13.
 */
//Given an unsorted array return whether an increasing subsequence of length
// 3 exists or not in the array.
//
//        Formally the function should:
//        Return true if there exists i, j, k
//        such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
//        Your algorithm should run in O(n) time complexity and O(1) space complexity.
//
//        Examples:
//        Given [1, 2, 3, 4, 5],
//        return true.
//
//        Given [5, 4, 3, 2, 1],
//        return false.
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int N = nums.length;
        int first = -1,last=-1;
        int i = 1;
        // 这个for循环的目的是找到第一组first last
        for(;i<N;i++){
            if(nums[i-1] < nums[i]){
                first = nums[i-1];
                last = nums[i];
                break;
            }
        }
        if(i==N)
            return false;

        // 目的是找第三个数
        for (i = i+1; i < N ; i++) {
            // 如果出现了一种符合要求的序列
            if(nums[i-1]<nums[i]){
                // 找个序列的第二项 大于last return true
                if(nums[i] > last)
                    return true;
                // 否则，first 变化，last 变化
                else{
                    first = Math.min(nums[i-1],first);
                    last = nums[i];
                }
            }
            // 正常情况下，first 可以不变，一步步将last 减小。
            else if(nums[i-1]> nums[i]){
                if(last > nums[i] && first < nums[i]){
                    last = nums[i];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence I = new IncreasingTripletSubsequence();
        int[] nums = {9,8,7,8,7,5,4,1};
        assert !I.increasingTriplet( nums );
        int[] nums2 = {9,8,7,8,7,9,4,1};
        assert I.increasingTriplet( nums2 );
        int [] nums3 = {-1,-2,0,-5,1};
        assert I.increasingTriplet( nums3 );
        int [] nums4 = {5,1,5,5,2,5};
        assert I.increasingTriplet( nums4 );
    }
}
