package Array;

import Tree.ConstructBinaryTreefromPreorderandInorderTraversal;
import Tree.TreeNode;

import java.util.Stack;

/**
 * Created by yyt on 2018/3/5.
 */
//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//        Example 1:
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 9
//
//        Output: True
//        Example 2:
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 28
//
//        Output: False
public class TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        stackAdd( left, true, root );
        stackAdd( right, false, root );

        while (left.peek() != right.peek()) {
            int a = left.peek().val;
            int b = right.peek().val;
            int n = a + b;
            if (k == n ) {
                return true;
            } else if (k > n)
                stackNext( left, true );
            else
                stackNext( right, false );
        }
        return false;
    }

    private void stackAdd(Stack<TreeNode> s, boolean isleft, TreeNode p) {
        while (p != null) {
            s.push( p );
            if (isleft)
                p = p.left;
            else
                p = p.right;
        }
    }

    private void stackNext(Stack<TreeNode> s, boolean isleft) {
        TreeNode p = s.pop();
        if (isleft)
            stackAdd( s, true, p.right );
        else
            stackAdd( s, false, p.left );

    }

    public static void main(String[] args) {
        int[] preorder = {2, 1, 3};
        int[] inorder = {1, 2, 3};
        ConstructBinaryTreefromPreorderandInorderTraversal c = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = c.buildTree( preorder, inorder );

        TwoSumIVBST t = new TwoSumIVBST();
        System.out.println( t.findTarget( root, 3 ) );
        String s= "aabba";
        char[]k = s.toCharArray();
    }
}
