package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of integers that might contain duplicates,
// nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        For example,
//        If nums = [1,2,2], a solution is:
//
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]
public class Subsets2 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<List<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<>();
        dfs(tempList, 0, nums);
        return res;
    }

    private void dfs(ArrayList<Integer> tempList, int index, int[] nums) {
        // 我觉得在这里可以利用判断的重复数字的个数，来随便玩一下。
        if (index >= nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        int count = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                count = i - index;
                break;
            } else if (i == nums.length - 1)
                count = i - index + 1;
        }
        // count 计算的是重复数字的个数。
        dfs(tempList, index + count, nums);
        for (int i = 0; i < count; i++) {
            tempList.add(nums[index]);
            dfs(tempList, index + count, nums);
        }
        for (int i = 0; i < count; i++)
            tempList.remove(tempList.size() - 1);

    }

    public static void main(String[] args) {
        Subsets2 s = new Subsets2();
        int[] nums = {1,2, 2,3};
        List<List<Integer>> t = s.subsetsWithDup(nums);
        for (List<Integer> k : t) {
            System.out.println(k.toString());
        }
    }

}
