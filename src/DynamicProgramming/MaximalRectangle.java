package DynamicProgramming;

/**
 * Created by yyt on 2018/1/12.
 */
//
//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 6.
public class MaximalRectangle {
    public MaximalRectangle() {

    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null)
            return 0;
        int M = matrix.length;
        if(M==0)
            return 0;
        int N = matrix[0].length;
        if(N==0)
            return 0;
        int max = 0;
        for (int i = 0; i < M; i++) {
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '1')
                        nums[j]++;
                    else
                        break;
                }
            }
            int temp = largestRectange( nums );
            max = Math.max( temp, max );
        }
        return max;

    }
    // 参见 同一题目的解释
    private int largestRectange(int[] nums) {
        int N = nums.length;
        int[] temp = new int[N];
        temp[0] = nums[0];
        int max = 0;

        for (int i = 1; i < N; i++) {
            temp[i] = nums[i];
            if (temp[i] < temp[i - 1]) {
                int count = 1;
                for (int j = i; j > 0 && temp[j] < temp[j - 1]; j--) {
                    max = Math.max( max, temp[j - 1] * count );
                    count++;
                    temp[j - 1] = temp[j];
                }
            }
        }
        max = Math.max( max, temp[0] * N );
        for (int i = 1; i < N; i++) {
            if(temp[i]>temp[i-1])
                max = Math.max( max,temp[i]*(N-i));
        }
        return max;
    }


    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();

        System.out.print( maximalRectangle.maximalRectangle( matrix ) );
    }
}
