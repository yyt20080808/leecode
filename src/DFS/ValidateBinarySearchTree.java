package DFS;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by yyt on 2018/1/19.
 */
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//        2
//        / \
//        1   3
//        Binary tree [2,1,3], return true.
//        Example 2:
//        1
//        / \
//        2   3
//        Binary tree [1,2,3], return false.
public class ValidateBinarySearchTree {
    private  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST2(TreeNode root) {
        // 非递归的形式来做这个题目
        // 中需遍历

        root = buildTree();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<>(  );
        TreeNode node = root;

        while(node != null || stack.size()>0){
            while(node != null){
                stack.add( node );

                node = node.left;
            }
            if(stack.size() > 0 ){
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        for(int i = 1;i<res.size();i++){
            if(res.get( i )<=res.get( i-1 ))
                return false;
        }
        return true;
    }
    private TreeNode buildTree(){
        TreeNode root = new TreeNode( 2 );
        TreeNode p1 = new TreeNode( 1 );
        TreeNode p2 = new TreeNode( 3 );
        TreeNode p3 = new TreeNode( 4 );
        root.left=p1;
        root.right=p2;
        p2.right=p3;


        return root;
    }




    public boolean isValidBST(TreeNode root) {

        return isValid( root, null, null );
    }

    private boolean isValid(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        // 用一个 low 和 high
        if ((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;
        // 在左边的时候，high 要变成 root.val, 在右边的时候 low 要变成root.val
        return isValid( root.left, low, root.val ) && isValid( root.right, root.val, high );

    }

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        v.isValidBST2(null);


    }
}
