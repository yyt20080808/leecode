package DynamicProgramming.HouseRobber;

/**
 * Created by yyt on 2018/1/29.
 */
//Note: This is an extension of House Robber.
//
//        After robbing those houses on that street, the thief has found himself a new place
// for his thievery so that he will not get too much attention. This time,
// all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
// Meanwhile, the security system for these houses remain the same as for those in the previous street.
//
//        Given a list of non-negative integers representing the amount of money of each house,
// determine the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber2 {
    public HouseRobber2() {

    }

    public int rob(int[] nums) {
        int N = nums.length;
        if(N==0)
            return 0;
        if(N==1)
            return nums[0];
        return Math.max( rob( nums, 0, N - 2 ), rob( nums, 1, N - 1 ) );
    }

    private int rob(int[] nums, int low, int high) {
        int N = nums.length;
//        int []dp = new int[N+1];
        int prev = 0;
        int now = nums[low];
        int temp;
        for (int i = low + 2; i <= high+1; i++) {
            // dp【i】是抢到第i-1个房子所获得的最大收益
            temp = now;
            now = Math.max( now, prev + nums[i - 1] );
            prev = temp;
        }
        return now;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,6,3,3,7,12,6};
        System.out.print(new HouseRobber2().rob( nums ) );
    }
}
