package DynamicProgramming.HouseRobber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yyt on 2018/1/29.
 */
public class HouseRobber3 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int x) {
            val = x;
        }
    }
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public static void main(String[] args) {

    }
}
