package Tree.PathSum;

import Tree.ConstructBinaryTreefromPreorderandInorderTraversal;
import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yyt on 2018/1/30.
 */
//You are given a binary tree in which each node contains an integer value.
//
//        Find the number of paths that sum to a given value.
//
//        The path does not need to start or end at the root or a leaf, but it must go downwards
// (traveling only from parent nodes to child nodes).
//
//        The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//
//        Example:
//
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        Return 3. The paths that sum to 8 are:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3. -3 -> 11
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // 从上往下的节点的累加和
        sum += curr.val;
        // 看看能在一条路径上累加和为 sum-target 的子路径的数目
        int numPathToCurr = map.getOrDefault(sum-target, 0);
        // 更新 累加和为sum的路径的数目
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // 看看在以后的节点中，以 两个子树为根，还能不能有子树能够到达这个sum 数值
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                + findPathSum(curr.right, sum, target, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public static void main(String[] args) {
        int[] preorder = {2,0,4,6,3,5,7};
        int[] inorder = {4,6,0,2,5,3,7};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder,inorder );
        PathSum3 p = new PathSum3();
        System.out.println(p.pathSum( root,6 ));
    }
}
