package DynamicProgramming;

import java.util.Stack;

/**
 * Created by yyt on 2017/11/7.
 */
//就是遍历数组，每找到一个局部峰值，然后向前遍历所有的值，算出共同的矩形面积，每次对比保留最大值
public class LargestRectange {
    public static int solution(int[] heights) {
        int N = heights.length;
        if (N == 0)
            return 0;
        int[] temp = new int[N];
        int maxArea = 0;
        temp[0] = heights[0];
        for (int i = 1; i < N; i++) {
            temp[i] = heights[i];
            // 如果小的话，那么就开始对前面的进行修改，遍历的方式进行修改
            if (temp[i] < temp[i - 1]) {
                int count = 1;
                for (int j = i; j > 0 && temp[j] < temp[j - 1]; j--) {
                    maxArea = Math.max( maxArea, temp[j - 1] * count );
                    count++;
                    // 变小了。
                    temp[j - 1] = temp[j];
                }
            }
        }
        int temp_max = temp[0];
        maxArea = Math.max( maxArea, temp_max * N );
        for (int i = 0; i < N; i++) {
            if (temp[i] > temp_max) {
                maxArea = Math.max( maxArea, temp[i] * (N - i) );
                temp_max = temp[i];
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6};

        System.out.print( solution( heights ) );
    }
}
