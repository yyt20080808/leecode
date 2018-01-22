package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yyt on 2018/1/19.
 */
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//        For example,
//        [1,1,2] have the following unique permutations:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
public class Permutations2 {
    public List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<List<Integer>>();
        Arrays.sort( nums );
        boolean[] isVisited = new boolean[nums.length];
        ArrayList<Integer> tempList = new ArrayList<>();
        dfs( nums, isVisited, 0, tempList );
        return res;
    }

    private void dfs(int[] nums, boolean[] isVisited, int level, ArrayList<Integer> tempList) {
        if (nums.length == level) {
            res.add( new ArrayList<>( tempList ) );
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && isVisited[i - 1])
                continue;
            isVisited[i] = true;
            tempList.add( nums[i] );
            dfs( nums, isVisited, level + 1, tempList );
            isVisited[i] = false;
            tempList.remove( tempList.size() - 1 );
        }

    }

    public static void main(String[] args) {
        Permutations2 s = new Permutations2();
        int[] a = {1,  1,4};
        s.permuteUnique( a );
    }
}
