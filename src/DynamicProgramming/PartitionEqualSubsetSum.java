package DynamicProgramming;

/**
 * Created by yyt on 2018/2/1.
 */
//Given a non-empty array containing only positive integers,
// find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//        Note:
//        Each of the array element will not exceed 100.
//        The array size will not exceed 200.
//        Example 1:
//
//        Input: [1, 5, 11, 5]
//
//        Output: true
//
//        Explanation: The array can be partitioned as [1, 5, 5] and [11].
//        Example 2:
//
//        Input: [1, 2, 3, 5]
//
//        Output: false
//
//        Explanation: The array cannot be partitioned into equal sum subsets.
public class PartitionEqualSubsetSum {
    public PartitionEqualSubsetSum() {

    }

    public boolean canPartition(int[] nums) {
        int sumAll = 0;
        int N = nums.length;
        for (int num : nums)
            sumAll += num;
        if (sumAll % 2 != 0)
            return false;
        int target = sumAll / 2;
        return subSetSum( nums, target );
    }
    // 思路就是和 背包问题是一样的，哈哈。
    private boolean subSetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
            if(dp[target]>0)
                return true;
        }
        return dp[target] != 0;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 5, 11};
        p.canPartition( nums );
    }
}
