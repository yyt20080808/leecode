package DynamicProgramming;

/**
 * Created by yyt on 2018/1/11.
 */
public class MaxumumProductSubarray {
    public MaxumumProductSubarray() {

    }

    public static int solutions(int[] nums) {
        int N = nums.length;
        // 其中dp_max[i] 表示nums[i]已经被选择中了
        int[] dp_min = new int[N];
        int[] dp_max = new int[N];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        for (int i = 1; i < N; i++) {
            dp_max[i] = Math.max( Math.max( dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i] ), nums[i] );
            dp_min[i] = Math.min( Math.min( dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i] ), nums[i] );
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (dp_max[i] > res)
                res = dp_max[i];
        }

        return res;

    }

    public static void main(String[] args) {
        int[] a = {12, 3, -2, 3, 1};
        System.out.print( solutions( a ) );
    }
}
