package Array;

/**
 * Created by yyt on 2018/1/26.
 */
//238
//    Given an array of n integers where n > 1, nums, return an array
// output such that output[i] is equal to the product of all the elements
// of nums except nums[i].
//
//            Solve it without division and in O(n).
//
//            For example, given [1,2,3,4], return [24,12,8,6].
//
//            Follow up:
//            Could you solve it with constant space complexity?
// (Note: The output array does not count as extra space for the purpose o
// f space complexity analysis.)
public class ProductOfArrayExceptSelf {
    public ProductOfArrayExceptSelf() {

    }
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[]res =new int[N];
        int temp = 1;
        // 计算0的数目
        int count0 = 0;
        for (int i = 0; i < N; i++){
            // 如果有2个0 全完蛋了
            if(nums[i]==0){
                count0++;
                if(count0 >1)
                    return res;
            }else
            temp  *= nums[i];
        }
        // 如果有一个0 那么就只有一个没有完蛋
        if(count0 == 1)
            for (int i = 0;i < N;i++){
                if(nums[i]==0){
                    res[i] = temp;
                    return res;
                }
            }
        for (int i = 0;i < N;i++){
            res[i] = temp / nums[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
