package DFS;

import LinkedList.InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/21.
 */
//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        For example,
//        If nums = [1,2,3], a solution is:
//
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class Subsets {
    public List<List<Integer>> res;

    public Subsets() {

    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        int N = nums.length;
        ArrayList<Integer> a = new ArrayList<>();
        backtrack( nums, 0, a );
        return res;
    }
    // Subsets, Permutations, Combination Sum, Palindrome Partitioning)
    private void backtrack(int[] nums, int index, ArrayList<Integer> a) {
        res.add( new ArrayList<>(a));

        for (int i = index; i < nums.length; i++) {
            a.add( nums[i] );
            backtrack( nums,i+1,a );
            a.remove( a.size()-1 );
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[]a = {1,2,3};
        s.subsets( a );
    }
}
