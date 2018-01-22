package Tree;

/**
 * Created by yyt on 2018/1/20.
 */
// 这道题是一个动态规划，还加上一个
public class BinaryTreeMaximumPathSum {
    public int maxNum;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int maxPathSum(TreeNode root) {
        maxNum = Integer.MIN_VALUE;
        maxPathDown( root );
        return maxNum;
    }
    private int maxPathDown(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0,maxPathDown( root.left ));
        int right = Math.max(0,maxPathDown( root.right) );
        maxNum = Math.max( maxNum,left+right+ root.val );
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

    }
}
