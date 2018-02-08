package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/31.
 */
//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
// some elements appear twice and others appear once.
//
//        Find all the elements of [1, n] inclusive that do not appear in this array.
//
//        Could you do it without extra space and in O(n) runtime?
// You may assume the returned list does not count as extra space.
//
//        Example:
//
//        Input:
//        [4,3,2,7,8,2,3,1]
//
//        Output:
//        [5,6]
public class FindAllNumbersDisappeared {
    public FindAllNumbersDisappeared() {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        // 最大值就是N
        int N = nums.length;
        int count = (N / 32) + 1;
        int[] store = new int[count];
        int temp1, temp2;
        // 相当于用bit记录了
        for (int e : nums) {
            temp1 = e / 32;
            temp2 = e % 32;
            store[temp1] |= 1 << temp2;
        }
        for (int i = 1; i <= N; i++) {
            temp1 = i / 32;
            temp2 = i % 32;
            if ((store[temp1] & (1 << temp2)) == 0)
                res.add( i );
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappeared f = new FindAllNumbersDisappeared();
        f.findDisappearedNumbers( nums );

    }
}
