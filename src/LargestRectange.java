import java.util.Stack;

/**
 * Created by yyt on 2017/11/7.
 */
//就是遍历数组，每找到一个局部峰值，然后向前遍历所有的值，算出共同的矩形面积，每次对比保留最大值
public class LargestRectange {
    public static int solution(int[] heights) {
        if (heights.length==0)
            return 0;
        int[] temp = new int[heights.length];
        int maxArea = 0;
        temp[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            temp[i] = heights[i];
            // 如果小的话，那么就开始对前面的进行修改，遍历的方式进行修改
            if (temp[i] < temp[i - 1]) {
                int j = i;
                int count = 1;
                while (j > 0 && temp[j] < temp[j - 1]  ) {
                    maxArea = Math.max(  maxArea,temp[j-1]*count);
                    count++;
                    temp[j - 1] = temp[j];
                    j--;
                }
            }
        }
        int temp_max = temp[0];
        maxArea =  Math.max( maxArea,temp_max* heights.length);
        for(int i =0;i<heights.length;i++){
            if(temp[i]>temp_max){
                maxArea = Math.max( maxArea,temp[i]*(heights.length-i));
                temp_max = temp[i];
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6};

        System.out.print( solution( heights ) );
    }
}
