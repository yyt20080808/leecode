package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyt on 2018/1/21.
 */
public class Permutations {
    public List<List<Integer>> res;

    public Permutations() {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<List<Integer>>();
        boolean[] isVisited = new boolean[nums.length];
        ArrayList<Integer> tempList = new ArrayList<>();
        backtrace( nums, 0, tempList, isVisited );
        return res;
    }

    private void backtrace(int[] nums, int level, List<Integer> templist, boolean[] isVisited) {
        if (level == nums.length) {
            res.add( new ArrayList<Integer>( templist ) );
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                templist.add( nums[i] );
                backtrace( nums, level + 1, templist, isVisited );
                isVisited[i] = false;
                templist.remove( templist.size() - 1 );
            }
        }

    }

    public static void main(String[] args) {
        Permutations s = new Permutations();
        int[] a = {1, 2, 3};
        s.permuteUnique( a );
    }
}
