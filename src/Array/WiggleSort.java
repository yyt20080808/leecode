package Array;

import java.util.Arrays;

/**
 * Created by yyt on 2018/3/8.
 */
//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//        Example:
//        (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
//        (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
//
//        Note:
//        You may assume all input has valid answer.
//
//        Follow Up:
//        Can you do it in O(n) time and/or in-place with O(1) extra space?

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int N = nums.length;
        if (N < 2)
            return;
        int mid = N / 2;
        int j = findMead( nums, 0, N - 1 );
        int low = 0, high = N - 1;
        while (j != mid) {
            if (j > mid) {
                high = j - 1;
            } else if (j < mid) {
                low = j + 1;
            }
            j = findMead( nums, low, high );
        }
        int left = 0,judge = 0,right = N-1;
        int[] index = backIndex( N );
        int key = nums[mid];
        while(judge <= right ){
            if(nums[index[judge]] > key){
                swap( nums,index[left++],index[judge++] );
            }else if(nums[index[judge]] < key)
                swap( nums,index[right--],index[judge] );
            else
                judge++;
        }
    }
    private int[] backIndex(int n){
        int[] index = new int[n];
        for (int i = 0;i < n;i++){
            index[i] = (1+2*i)%(n|1);
        }
        return index;
    }

    private int findMead(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        int key = nums[low];
        while (true) {
            while (nums[--j] > key && j > low)
                ;
            while (nums[++i] < key && i < high)
                ;
            if (i < j) {
                swap( nums, i, j );
            } else {
                swap( nums, low, j );
                return j;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        WiggleSort w = new WiggleSort();
        int[] nums = {1,3,2,2,3,1};
        w.wiggleSort( nums );

        System.out.print( Arrays.toString( nums ) );

    }
}
