package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yyt on 2018/2/4.
 */
//You are given an integer array nums and you have to return
// a new counts array. The counts array has the property where counts[i]
// is the number of smaller elements to the right of nums[i].
//
//        Example:
//
//        Given nums = [5, 2, 6, 1]
//
//        To the right of 5 there are 2 smaller elements (2 and 1).
//        To the right of 2 there is only 1 smaller element (1).
//        To the right of 6 there is 1 smaller element (1).
//        To the right of 1 there is 0 smaller element.
//        Return the array [2, 1, 1, 0].
public class CountShort {
    private int[] aux;

    // 定义一个数组pos，用来表示排名第i个数组的元素下标是j
    private void mergeSort(int[] nums, int[] pos, int[] counts, int low, int high) {
        if (low >= high) {
//            if (low < high && nums[low] > nums[high]) {
//                int temp = nums[low];
//                nums[low] = nums[high];
//                nums[high] = temp;
//            }
            return;
        }
        int mid = (low + high) / 2;
        mergeSort( nums, pos, counts, low, mid );
        mergeSort( nums, pos, counts, mid + 1, high );
        int left = low, right = mid + 1;
        int k = 0,jump = 0;

        while (left <= mid || right <= high) {
            if (left > mid){
                aux[low + k] = pos[right++];
            }
            else if (right > high){
                //后面的数字跑到了前面
                counts[pos[left]] += jump;
                aux[low + k] = pos[left++];
            }
            else if (nums[pos[left]] <= nums[pos[right]]){
                // 后面数字往后跑
                counts[pos[left]]+=jump;
                aux[low + k] = pos[left++];
            }
            else{
                // 让 后面的数字 填充了进来，以后 left那一侧的数字都要加上这个jump值。
                jump++;
                aux[low + k] = pos[right++];
            }
            k++;
        }
        for (int i = low; i <= high; i++)
            pos[i] = aux[i];
    }

    public List<Integer> countSmaller(int[] nums) {
        aux = new int[nums.length];
        int[] pos = new int[nums.length];
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            pos[i] = i;
        mergeSort( nums, pos, counts, 0, nums.length - 1 );
        List<Integer> res =  new ArrayList<>(  );
        for (int e:counts)
            res.add( e );
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 3, 9, 10, 5, 7, 3, 1};
        CountShort c = new CountShort();
        c.countSmaller( nums );
        for (int e : nums) {
            System.out.println( e );
        }
    }
}
