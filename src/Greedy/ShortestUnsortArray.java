package Greedy;

/**
 * Created by yyt on 2018/2/2.
 */
//Given an integer array, you need to find one continuous subarray that
// if you only sort this subarray in ascending order, then the whole array
// will be sorted in ascending order, too.
//
//        You need to find the shortest such subarray and output its length.
//
//        Example 1:
//        Input: [2, 6, 4, 8, 10, 9, 15]
//        Output: 5
//        Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
// the whole array sorted in ascending order.
//        Note:
//        Then length of the input array is in range [1, 10,000].
//        The input array may contain duplicates, so ascending order here means <=.
public class ShortestUnsortArray {
    public int findUnsortedSubarray(int[] nums) {
        // 感觉就是从前往后找到第一个逆序对，从后往前找到第二个逆序对
        // 第一个逆序对 要找到一个最小的数，小于 前面的
        int startIndex = 0;
        int N = nums.length;
        while(startIndex < N-1){
            if(nums[startIndex] > nums[startIndex+1])
                break;
            startIndex++;
        }
        // 如果就是一个已经排序好的序列，就直接返回0 就可以了
        if (startIndex==N-1)
            return 0;

        int small = nums[startIndex+1],smallIndex = startIndex +1;
        // 然后找到最小的那个数字，得到它的index
        for (int i = startIndex+1; i < N; i++){
            if(nums[i]< small){
                smallIndex = i;
                small = nums[i];
            }
        }

        // 往前遍历，去发现一比这个还小的数字
        for ( startIndex = startIndex-1; startIndex >=0  ; startIndex--) {
            if(nums[startIndex] <= small)
                break;
        }
        // 表示开始的地点
        startIndex+=1;

//        // 第二个步骤，从后往前遍历
        int endIndex = N-1;
        while(endIndex > smallIndex){
            if(nums[endIndex] < nums[endIndex-1])
                break;
            endIndex--;
        }
        int big = nums[endIndex-1];
        // 然后找到最大的那个数字，得到它的index
        for (int i = endIndex-1; i >=0 ; i--) {
            big = Math.max(nums[i],big);
        }
        // 往后遍历，去发现一比这个还大的数字
        for ( endIndex = endIndex+1; endIndex < N; endIndex++){
            if(nums[endIndex] >= big)
                break;
        }

        return endIndex-startIndex;
    }

    public static void main(String[] args) {
        ShortestUnsortArray s = new ShortestUnsortArray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(  s.findUnsortedSubarray( nums ));
    }
}
