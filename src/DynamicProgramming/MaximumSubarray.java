package DynamicProgramming;

/**
 * Created by yyt on 2018/1/11.
 */
public class MaximumSubarray {
    public MaximumSubarray() {

    }

    public static int solutions(int[] nums) {
        int N = nums.length;
        // local[i] 表示包含nums[i]，i之前的子串的最大和。
        int[] local = new int[N];
        local[0] = nums[0];
        for (int i = 1; i < N; i++) {
            local[i] = Math.max( local[i - 1] + nums[i], nums[i] );
        }
        // globals[i]表示i之前的全局字串的最大和
        int[] globals = new int[N];
        globals[0] = nums[0];

        for (int i = 1; i < N; i++) {
            globals[i] = Math.max( globals[i - 1], local[i] );
        }
        return globals[N-1];
    }

    public static void main(String[] args) {
        int []a = {1,2,3,4,-5,-5,-1,3,0,4,3,1};
        System.out.print( solutions( a ));
    }
}
